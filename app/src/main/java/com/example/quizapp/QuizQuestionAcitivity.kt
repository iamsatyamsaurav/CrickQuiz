package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import org.w3c.dom.Text

class QuizQuestionAcitivity : AppCompatActivity() , View.OnClickListener{

    private var mCurrentPosition:Int=1
    private var mQuestionList:ArrayList<Question>?=null
    private var mSelectedOptionPosition:Int=0
    
    private var tvQuestion:TextView?=null
    private var ivImage:ImageView?=null
    private var progressBar:ProgressBar?=null
    private var tvProgress:TextView?=null

    private var tvOptionOne : TextView?=null
    private var tvOptionTwo : TextView?=null
    private var tvOptionThree : TextView?=null
    private var tvOptionFour : TextView?=null

    private var btnSubmit:Button?=null

    private var mCorrectAnswer:Int=0
    private var mUserName:String?=null  //for the passed username

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question_acitivity)
        tvQuestion=findViewById(R.id.tv_question)
        ivImage=findViewById(R.id.iv_image)
        progressBar=findViewById(R.id.progressBar)
        tvProgress=findViewById(R.id.tv_progress)
        tvOptionOne=findViewById(R.id.tv_option_one)
        tvOptionTwo=findViewById(R.id.tv_option_two)
        tvOptionThree=findViewById(R.id.tv_option_three)
        tvOptionFour=findViewById(R.id.tv_option_four)
        btnSubmit=findViewById(R.id.btn_submit)

        mUserName=intent.getStringExtra(Constants.USER_NAME)  //to fetch the data that was being sent by the previous activity using intent

        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        mQuestionList = Constants.getQuestions()
        setQuestion()
    }

    //function to handle the enabling and disabling of options when clicked once on submit button
    private fun enableOptions(enable: Boolean) {
        tvOptionOne?.isEnabled = enable
        tvOptionTwo?.isEnabled = enable
        tvOptionThree?.isEnabled = enable
        tvOptionFour?.isEnabled = enable
    }

    private fun setQuestion() {


        defaultOptionsView()

        enableOptions(true)//enable options

        val question = mQuestionList!![mCurrentPosition - 1]
        tvQuestion?.text = question.question
        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition/${progressBar?.max}"
        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour
        ivImage?.setImageResource(question.image)


        if(mCurrentPosition==mQuestionList!!.size){
            btnSubmit?.text="FINISH"
        }
        else{
            btnSubmit?.text="SUBMIT"
        }
    }

    fun defaultOptionsView(){
        val options=ArrayList<TextView>()
        tvOptionOne?.let {
            options.add(0,it)
        }
        tvOptionTwo?.let {
            options.add(1,it)
        }
        tvOptionThree?.let {
            options.add(2,it)
        }
        tvOptionFour?.let {
            options.add(3,it)
        }
        for(option in options){
            option.setTextColor(Color.parseColor("#7a8089"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(
                this,
                R.drawable.option_bg
            )
        }


    }

    private fun selectedOptionView(tv:TextView,selectedOptionNum:Int){
         defaultOptionsView()
        mSelectedOptionPosition=selectedOptionNum
        tv.setTextColor(Color.parseColor("#363a43"))
        tv.typeface= Typeface.DEFAULT_BOLD
        tv.background=ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_bg
        )
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.tv_option_one->{
                tvOptionOne?.let {
                    selectedOptionView(it,1)
                }
            }
            R.id.tv_option_two->{
                tvOptionTwo?.let {
                    selectedOptionView(it,2)
                }
            }
            R.id.tv_option_three->{
                tvOptionThree?.let {
                    selectedOptionView(it,3)
                }
            }
            R.id.tv_option_four->{
                tvOptionFour?.let {
                    selectedOptionView(it,4 )
                }
            }
            R.id.btn_submit->{
                if(mSelectedOptionPosition==0){  //this will also allow us to go to next question even without selecting any option
                    mCurrentPosition++

                    when{
                        mCurrentPosition<=mQuestionList!!.size->{

                            setQuestion()
                        }
                        else->{
                            //no questions left and we click on finish
                            //move to result activity
                            val intent=Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME,mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswer)
                            intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }else{
                    val question=mQuestionList?.get(mCurrentPosition-1)
                    if(question!!.correctAns!=mSelectedOptionPosition){
                        //incorrect answer
                        answerView(mSelectedOptionPosition,R.drawable.wrong_option_bg)
                    }else{
                        //correct answer
                        mCorrectAnswer++;
                    }

                    answerView(question.correctAns,R.drawable.correct_option_bg)

                    enableOptions(false)//disable options when once clicked on submit

                    if(mCurrentPosition==mQuestionList!!.size){
                        btnSubmit?.text="FINISH"
                    }
                    else{
                        btnSubmit?.text="GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition=0 // so that on further clicking we can go to next question


                }
            }
        }
    }
    private fun answerView(answer:Int,drawableView:Int){
        when(answer){
            1->{
                tvOptionOne?.background=ContextCompat.getDrawable(
                    this,
                    drawableView //will depend on whether we chose right or wrong answer
                )
            }
            2->{
                tvOptionTwo?.background=ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3->{
                tvOptionThree?.background=ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4->{
                tvOptionFour?.background=ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }



}