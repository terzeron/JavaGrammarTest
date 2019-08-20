package com.terzeron.grammar.try_with_resources;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

@Slf4j
public class TryWithResourcesTest {
    public static void main(String[] args) throws FileNotFoundException {

        try (
                FileReader fr = new FileReader("input.txt");
                BufferedReader br = new BufferedReader(fr)
        ) {
            String line;
            while (null != (line = br.readLine())) {
                // processing each line of file
                System.out.println(line);
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }
}
