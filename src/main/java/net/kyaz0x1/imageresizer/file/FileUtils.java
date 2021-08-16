package net.kyaz0x1.imageresizer.file;

import net.kyaz0x1.imageresizer.file.type.FileExtensionType;

import java.io.File;
import java.util.Arrays;
import java.util.Locale;

public final class FileUtils {

    private FileUtils(){}

    public static boolean hasExtension(File file, FileExtensionType type){
        final String name = file.getName();
        return getFormat(file).equals(type.getExtension());
    }

    public static boolean hasExtensions(File file, FileExtensionType ... types){
        return Arrays.asList(types).stream().anyMatch(type -> hasExtension(file, type));
    }

    public static String getFormat(File file){
        final String name = file.getName();
        return name.toLowerCase().substring(name.lastIndexOf("."));
    }

}