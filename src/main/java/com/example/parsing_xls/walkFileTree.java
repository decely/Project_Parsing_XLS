package com.example.parsing_xls;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class walkFileTree {

    public static List<String> getWalkTree(String folderPath) throws IOException {
        List<String> pathList = new ArrayList<>();

        Path path = Paths.get(folderPath);
        List<Path> paths = listFiles(path);
        paths.forEach(x -> pathList.add(x.toString()));

        return pathList;
    }

    public static List<Path> listFiles(Path path) throws IOException {

        List<Path> result;
        try (Stream<Path> walk = Files.walk(path)) {
            result = walk.filter(Files::isRegularFile)
                    .collect(Collectors.toList());
        }
        return result;

    }
}
