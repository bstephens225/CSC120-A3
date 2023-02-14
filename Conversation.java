import java.util.Scanner;

class Conversation {
  //be able to tell if we should reapond with a question
  public static boolean question = false;
  public static void main(String[] arguments) {
    
    Scanner sc = new Scanner(System.in);

    //ask how many rounds
    System.out.println("how many rounds?");
    int rounds;
    rounds=sc.nextInt();
    //make the transcript
    String[] transcript = new String[rounds*2+8];
    int transcriptNum=0;
    transcript[transcriptNum]="how many rounds?";
    transcriptNum++;
    transcript[transcriptNum]=Integer.toString(rounds);

    //start the convo
    for (int i=0;i<rounds+1;i++){
      //listen and respond
      String statement=sc.nextLine();
      String reply=respond(statement);
      System.out.println(reply);

      //add to transcript
      if (i>0){
        transcriptNum++;
        transcript[transcriptNum]=statement;
      }
      transcriptNum++;
      transcript[transcriptNum]=reply;
    }
    //finish the convo
    System.out.println("We're done here");
    transcriptNum++;
    transcript[transcriptNum]="We're done here";
    
    //print transcript
    System.out.println("-----TRANSCRIPT-----");
    for (int i=0; i<transcriptNum+1;i++){
      System.out.println(transcript[i]);
    }
    System.out.println("-----END TRANSCRIPT-----");
  }
  //replace pronouns from list
  public static String replacePronouns(String statement, String target, String replacement){
      statement=statement.replaceAll("\\b"+target+"\\b", "h0ld3r");
      if (statement.contains("h0ld3r")){question=true;}
      statement=statement.replaceAll("h0ld3r",replacement);
    
    return statement;
  }
  //work out how to respond
  public static String respond(String statement){
    //respond if they asked a question
    if (statement.contains("?")){
      return "idk";
    }
    //respond with a q if they used pronouns
    String response = statement;
    question=false;
    response=replacePronouns(response,"your", "m1y");
    response=replacePronouns(response,"I", "y0u");
    response=replacePronouns(response,"you", "I");
    response=replacePronouns(response,"am", "ar3");
    response=replacePronouns(response,"are", "am");
    response=replacePronouns(response,"ar3", "are");
    response=replacePronouns(response,"my", "your");
    response=replacePronouns(response,"m1y", "my");
    response=replacePronouns(response,"y0u", "you");
    response=replacePronouns(response,"me", "you");

    if (question==true){
      return response +"?";
    }else{
      //respond with random reply
      String[] replies = {"ok...", "huh", "cool, yeah...", "wow"};
      String randReply=replies[(int)(Math.random()*4)];

      return randReply;
    }
  }
  
}



