package com.didanko228.tghealthreminder.utils;

import io.github.cdimascio.dotenv.Dotenv;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Config {
    private static final Dotenv dotenv = Dotenv.load();

    public static String BOT_TOKEN = dotenv.get("BOT_TOKEN");

    private static final String adminValue = dotenv.get("ADMINS");
    public static Set<Long> ADMINS = Arrays.stream(Objects.requireNonNull(adminValue).split(","))
            .map(Long::parseLong)
            .collect(Collectors.toSet());

    public static String MONGODB_URL = dotenv.get("MONGODB_URL");
}
