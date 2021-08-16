package net.kyaz0x1.imageresizer.events;

import net.kyaz0x1.imageresizer.file.FileUtils;
import net.kyaz0x1.imageresizer.file.filter.FileImageFilter;
import net.kyaz0x1.imageresizer.file.type.FileExtensionType;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ButtonChooseFileEvent implements ActionListener {

    private final JFileChooser chooser;
    private final JTextField txtFile;

    public ButtonChooseFileEvent(JTextField txtFile){
        this.chooser = new JFileChooser(System.getProperty("user.home") + "\\Pictures");
        chooser.setFileFilter(new FileImageFilter());
        this.txtFile = txtFile;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final int result = chooser.showOpenDialog(null);
        if(result == JFileChooser.APPROVE_OPTION){
            final File file = chooser.getSelectedFile();
            if(!FileUtils.hasExtensions(file, FileExtensionType.PNG, FileExtensionType.JPG)){
                JOptionPane.showMessageDialog(null, "O arquivo tem uma extensão inválida! Tente com as extensões [.png, .jpg]", "ImageResizer", JOptionPane.ERROR_MESSAGE);
                return;
            }
            txtFile.setText(file.getAbsolutePath());
        }
    }

}