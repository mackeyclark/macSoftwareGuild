/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abeginning;

/**
 *
 * @author macam
 */
public class Arrays {
    public static void main(String[] args) {
        
        String [][] cityTeamNames = {
            {"CLeaveland", "Browns", "Cavs", "Indians"},
            {"Columbus", "Bluejackets", "Buckeyes"},
            {"Pittsburg", "Steelers", "Pirates", "Penguins"}
                };
        
        for(int i = 0; i < cityTeamNames.length; i++){
            for(int j = 0; j < cityTeamNames[i].length; j++)
                System.out.print(cityTeamNames[i][j] + " ");
                
        }
        System.out.println();
        
        /*int[] teamScores;
        
        teamScores = new int[5];
        
        teamScores[0] = 2;
        teamScores[1] = 45;
        teamScores[2] = 4;
        teamScores[3] = 8;
        teamScores[4] = 99;
        
        int[] golfScores = {72, 74, 68, 71};
        
        int currentGolfScore = golfScores[0];
        
        golfScores[2] = 70;
        
        for(int i = 0; i < golfScores.length; i++) {
            System.out.println(golfScores[i]);
        }
        for(int currentScore : golfScores){
            System.out.println(currentScore);*/

        }
    }
