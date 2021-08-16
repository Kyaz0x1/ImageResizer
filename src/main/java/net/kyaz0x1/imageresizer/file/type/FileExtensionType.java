package net.kyaz0x1.imageresizer.file.type;

public enum FileExtensionType {

    PNG(".png"),
    JPG(".jpg");

    private String extension;

    FileExtensionType(String extension){
        this.extension = extension;
    }

    public String getExtension() {
        return extension;
    }

}