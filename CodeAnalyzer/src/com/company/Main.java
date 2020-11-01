package com.company;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        String errorString = "문제 번호를 입력해주세요.";
        String correctString = "정답입니다!";
        String wrongString = "틀렸습니다.";
        Boolean result = false;

        if(args.length > 1) {
            String userId = args[0];
            Integer problemNumber = Integer.parseInt(args[1]);

            String userProblemString = "";
            String solutionString = "";

            try {
                File userFile = new File("/config/workspace/problems/problem" + problemNumber + ".java");
                File solutionFile = new File("/opt/secubook_problem/solutions/solution" + problemNumber + ".java");

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

                String resultString = "";

                if (result) resultString = correctString;
                else resultString = wrongString;

                // 결과 출력
                StringBuilder fileOutString = new StringBuilder();
                File logFile = new File("/opt/secubook/log/score/score.txt");
                BufferedWriter bw = new BufferedWriter(new FileWriter(logFile, true));
                PrintWriter pw = new PrintWriter(bw, true);

                // 시간 계산
                SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
                Date time = new Date();
                String timeString = format.format(time);

                // 결과 string
                fileOutString.append(timeString + " " + userId + " " + problemNumber + " " + resultString + "\n");
                pw.write(fileOutString.toString());
                pw.flush();
                pw.close();

                System.out.println(fileOutString.toString());

            } catch (FileNotFoundException e) {
                e.getStackTrace();
            } catch (IOException e) {
                e.getStackTrace();
            }




        }else {
            System.out.println(errorString);
        }
    }
}
