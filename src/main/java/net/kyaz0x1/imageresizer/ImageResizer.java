package net.kyaz0x1.imageresizer;

import net.kyaz0x1.imageresizer.view.ImageResizerView;

import javax.swing.SwingUtilities;

public class ImageResizer {

    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> new ImageResizerView().setVisible(true));
    }

}
