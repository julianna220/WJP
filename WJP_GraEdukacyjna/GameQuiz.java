/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WJP_GraEdukacyjna;

import java.util.Random;

/**
 *
 * @author Lucek
 */
public class GameQuiz {
    
 public static String[][] QuestionsS = new String[3][4]; 
 public static String[][] QuestionsI = new String[3][4]; 
 public static String[][] QuestionsA = new String[3][4]; 
  
  public static void QuestionsAnswers(){
     
      
    Random r = new Random();

    int nr = r.nextInt(3);
    int nr2 = r.nextInt(3);
    while (nr == nr2){nr2 = r.nextInt(3);}
    int nr3 = r.nextInt(3);
    while ( (nr == nr3)|| (nr2 == nr3) ){nr3 = r.nextInt(3);}
    
    QuestionsS = new String[3][4];
    
    for (int i=0; i < 1; i++){
        for(int j=0; j<=3;j++)
    
    QuestionsS[nr3][j] = GameConst.QuestionsSwitzerland[0][j];

    }
    for (int a=0; a < 1; a++){
        for(int b=0; b<=3;b++)
    
  
    QuestionsS[nr2][b] = GameConst.QuestionsSwitzerland[1][b];

    }
    
    for (int g=0; g < 1; g++){
        for(int h=0; h<=3;h++)
    
  
    QuestionsS[nr][h] = GameConst.QuestionsSwitzerland[2][h];
        
    }
    
    
    
    
    
    
    
    
    QuestionsI = new String[3][4];
    
    for (int i=0; i < 1; i++){
        for(int j=0; j<=3;j++)
    
    QuestionsI[nr3][j] = GameConst.QuestionsIceland[0][j];

    }
    for (int a=0; a < 1; a++){
        for(int b=0; b<=3;b++)
    
  
    QuestionsI[nr2][b] = GameConst.QuestionsIceland[1][b];

    }
    
    for (int g=0; g < 1; g++){
        for(int h=0; h<=3;h++)
    
  
    QuestionsI[nr][h] = GameConst.QuestionsIceland[2][h];

    }
  
    
    
    
    
    
    
    
    QuestionsA = new String[3][4];
    
    for (int i=0; i < 1; i++){
        for(int j=0; j<=3;j++)
    
    QuestionsA[nr3][j] = GameConst.QuestionsAlbania[0][j];

    }
    for (int a=0; a < 1; a++){
        for(int b=0; b<=3;b++)
    
  
    QuestionsA[nr2][b] = GameConst.QuestionsAlbania[1][b];

    }
    
    for (int g=0; g < 1; g++){
        for(int h=0; h<=3;h++)
    
  
    QuestionsA[nr][h] = GameConst.QuestionsAlbania[2][h];
        
    }
  }}

