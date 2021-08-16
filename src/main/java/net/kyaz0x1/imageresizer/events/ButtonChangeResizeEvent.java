package net.kyaz0x1.imageresizer.events;

import net.kyaz0x1.imageresizer.controller.ImageController;
import net.kyaz0x1.imageresizer.utils.NumberUtils;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ButtonChangeResizeEvent implements ActionListener {

    private final JTextField txtFile;
    private final JTextField txtWidth;
    private final JTextField txtHeight;

    public ButtonChangeResizeEvent(JTextField txtFile, JTextField txtWidth, JTextField txtHeight){
        this.txtFile = txtFile;
        this.txtWidth = txtWidth;
        this.txtHeight = txtHeight;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final String strFile = txtFile.getText();
        final File file = new File(strFile);

        if(strFile.isEmpty()){
            JOptionPane.showMessageDialog(null, "Selecione uma imagem!", "ImageResizer", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(!file.exists()){
            JOptionPane.showMessageDialog(null, "A imagem informada não existe!", "ImageResizer", JOptionPane.ERROR_MESSAGE);
            return;
        }

        final String strWidth = txtWidth.getText(), strHeight = txtHeight.getText();

        if(!NumberUtils.isNumber(strWidth)){
            JOptionPane.showMessageDialog(null, "O width informado é inválido!", "ImageResizer", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(!NumberUtils.isNumber(strHeight)){
            JOptionPane.showMessageDialog(null, "O height informado é inválido!", "ImageResizer", JOptionPane.ERROR_MESSAGE);
            return;
        }

        final int width = Integer.parseInt(strWidth), height = Integer.parseInt(strHeight);

        if(width < 0 || height < 0){
            JOptionPane.showMessageDialog(null, "Os valores não podem ser menores que zero.", "ImageResizer", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ImageController.getInstance().resize(file, width, height);
    }

}