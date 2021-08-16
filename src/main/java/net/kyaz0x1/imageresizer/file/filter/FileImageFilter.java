package net.kyaz0x1.imageresizer.file.filter;

import net.kyaz0x1.imageresizer.file.FileUtils;
import net.kyaz0x1.imageresizer.file.type.FileExtensionType;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class FileImageFilter extends FileFilter {

    @Override
    public boolean accept(File file) {
        return file.isDirectory() || FileUtils.hasExtensions(file, FileExtensionType.PNG, FileExtensionType.JPG);
    }

    @Override
    public String getDescription() {
        return "Image (.png, .jpg)";
    }

}