package com.example.quizapp

object Constants {

    //we are passing these data to another screen
    //these are acting as key which will help us in retrieving the data
    const val USER_NAME : String="user_name"
    const val TOTAL_QUESTIONS : String="total_questions"
    const val CORRECT_ANSWERS: String="correct_answers"


    fun getQuestions():ArrayList<Question>{
        val questionList=ArrayList<Question>()

        val que1=Question(
            1,
            "Which Indian cricketer is shown in this image, known for scoring the highest individual score in Test cricket for India?",
            R.drawable.img1,
            "Sachin Tendulkar",
            "Virender Sehwag",
            "VVS Laxman",
            "Rahul Dravid",
            2
        )
        questionList.add(que1)
        val que2=Question(
            2,
            "This image captures a memorable moment in Indian cricket history. What was the significance of this event?",
            R.drawable.img2,
            "India winning the 1983 World Cup",
            "Anil Kumble's 10-wicket haul in an innings",
            "Yuvraj Singh hitting six sixes in an over",
            "MS Dhoni's winning six in the 2011 World Cup final",
            4
        )
        questionList.add(que2)
        val que3=Question(
            3,
            "Which iconic Indian cricket stadium is shown in this image, known for hosting many historical matches?",
            R.drawable.img3,
            "Eden Gardens, Kolkata",
            "Wankhede Stadium, Mumbai",
            "M. A. Chidambaram Stadium, Chennai",
            "M. Chinnaswamy Stadium, Bangalore",
            1
        )
        questionList.add(que3)
        val que4=Question(
            4,
            " This image shows the Indian cricket team's jersey from a particular era. Which tournament was this jersey first used?",
            R.drawable.img4,
            "1992 Cricket World Cup",
            "1996 Cricket World Cup",
            "2003 Cricket World Cup",
            "2011 Cricket World Cup",
            1
        )
        questionList.add(que4)
        val que5=Question(
            5,
        "Which Indian bowler is known for the celebration shown in this image, characterized by a unique jump and fist pump?",
        R.drawable.img5,
            "Zaheer Khan",
            "Harbhajan Singh",
            "Javagal Srinath",
            "Ishant Sharma",
            2
        )
        questionList.add(que5)
        val que6=Question(
            6,
            "This image shows a famous partnership between two Indian batsmen. In which match did they share a record partnership?",
            R.drawable.img6,
            "Sachin Tendulkar and Sourav Ganguly in Sharjah 1998",
            "VVS Laxman and Rahul Dravid against Australia in 2001",
            "MS Dhoni and Yuvraj Singh against England in 2008",
            "Virat Kohli and Rohit Sharma against West Indies in 2018",
            2
        )
        questionList.add(que6)
        val que7=Question(
            7,
            "This image captures a bowler who took a hat-trick in the World Cup. Who is he?",
            R.drawable.img7,
            "Kapil Dev",
            "Chetan Sharma",
            "Jasprit Bumrah",
            "Anil Kumble",
            2
        )
        questionList.add(que7)
        val que8=Question(
            8,
            " This image shows Indian players celebrating after a historic Test match victory. Which match was it?",
            R.drawable.img9,
            "India vs Australia, 2001, Kolkata",
            "India vs England, 2002, Leeds",
            "India vs South Africa, 2018, Johannesburg",
            "India vs Pakistan, 2004, Multan",
            1
        )
        questionList.add(que8)
        val que9=Question(
            9,
            "The player in this image took one of the most iconic catches in Indian cricket history. Who is he?",
            R.drawable.img8,
            "Kapil Dev",
            "Mohammad Kaif",
            "Suresh Raina",
            "Rahul Dravid",
            1
        )
        questionList.add(que9)
        val que10=Question(
            10,
            "This image shows Virat Kohli celebrating after scoring a century. In which match did he score a century in just 52 balls?",
            R.drawable.img10,
            "India vs Pakistan, 2012, Asia Cup",
            "India vs South Africa, 2018, Cape Town Test",
            "India vs Australia, 2013, Jaipur ODI",
            "India vs West Indies, 2015, ODI series",
            3
        )
        questionList.add(que10)
        return questionList
    }
}