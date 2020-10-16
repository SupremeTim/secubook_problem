package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        String errorString = "문제 유형과 번호를 입력해주세요.";
        String correctString = "정답입니다!";
        String wrongString = "틀렸습니다.";
        Boolean result = false;

        if(args.length > 1) {
            String problemCategory = args[0];
            Integer problemNumber = Integer.parseInt(args[1]);

            String userProblemString = "";
            String solutionString = "";

            try {
                File userFile = new File("/config/workspace/problems/" + problemCategory + "/problem" + problemNumber + ".java");
                File solutionFile = new File("/opt/secubook_problem/solutions/" + problemCategory + "/solution" + problemNumber + ".java");

                FileReader userFileReader = new FileReader(userFile);
                FileReader solutionFileReader = new FileReader(solutionFile);

                int cur = 0;
                while ((cur = userFileReader.read()) != -1) {
                    userProblemString += (char) cur;
                }
                userFileReader.close();

                cur = 0;
                while ((cur = solutionFileReader.read()) != -1) {
                    solutionString += (char) cur;
                }
                solutionFileReader.close();

                // TODO: 정답 checking 알고리즘
                result = userProblemString.contains(solutionString);

            } catch (FileNotFoundException e) {
                e.getStackTrace();
            } catch (IOException e) {
                e.getStackTrace();
            }

            if (result) {
                System.out.println(correctString);
            } else {
                System.out.println(wrongString);
            }

        }else {
            System.out.println(errorString);
        }
    }
}
