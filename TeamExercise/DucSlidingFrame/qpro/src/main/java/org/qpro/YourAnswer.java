package org.qpro;

import sun.misc.IOUtils;
import sun.nio.ch.IOUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class YourAnswer {

    public void answerTo(InputStream input, OutputStream output) throws Exception {
        // insert your answer please
        Scanner scanner = new Scanner(input);
        int len = scanner.nextInt();
        int[] inputArr = new int[len];
        int size = scanner.nextInt();
        for(int i = 0; i < len; i++) {
            if(scanner.hasNext()) {
                inputArr[i] = scanner.nextInt();
            }
        }
        int pickItem = size / 2;
        int timeToRun = len - size + 1;
        List<Integer> rs = new ArrayList<>(timeToRun);
        for(int j = 0, k = size; j < timeToRun; j++, k++) {
            int[] scanArr;
            scanArr = Arrays.copyOfRange(inputArr, j, k);
            Arrays.sort(scanArr);
            rs.add(scanArr[pickItem]);
        }
        String outString = buildAns(rs);
        output.write(outString.getBytes());
    }

    private String buildAns(List<Integer> filterList) {
        StringBuilder builder = new StringBuilder(filterList.size());
        filterList.forEach(item -> {
            builder.append(item).append("\n");
        });
        return builder.toString();
    }

}

