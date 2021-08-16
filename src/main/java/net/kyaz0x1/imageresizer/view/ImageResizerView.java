package net.kyaz0x1.imageresizer.view;

import com.formdev.flatlaf.FlatLightLaf;
import net.kyaz0x1.imageresizer.events.ButtonChangeResizeEvent;
import net.kyaz0x1.imageresizer.events.ButtonChooseFileEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ImageResizerView extends JFrame {

    private final JLabel lblFile;
    private final JTextField txtFile;
    private final JButton btnChooseFile;

    private final JLabel lblWidth;
    private final JTextField txtWidth;

    private final JLabel lblHeight;
    private final JTextField txtHeight;

    private final JButton btnChangeFile;

    public ImageResizerView(){
        super("ImageResizer v1.0.0");
        setSize(330, 180);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        FlatLightLaf.setup();

        this.lblFile = new JLabel("Arquivo:");
        lblFile.setBounds(10, 5, 50, 20);

        add(lblFile);

        this.txtFile = new JTextField();
        txtFile.setEnabled(false);
        txtFile.setBounds(60, 6, 150, 20);

        add(txtFile);

        this.btnChooseFile = new JButton("Escolher");
        btnChooseFile.addActionListener(new ButtonChooseFileEvent(txtFile));
        btnChooseFile.setBounds(213, 6, 90, 20);

        add(btnChooseFile);

        this.lblWidth = new JLabel("Width:");
        lblWidth.setBounds(132, 27, 40, 20);

        add(lblWidth);

        this.txtWidth = new JTextField();
        txtWidth.setHorizontalAlignment(SwingConstants.CENTER);
        txtWidth.setBounds(105, 47, 90, 20);

        add(txtWidth);

        this.lblHeight = new JLabel("Height:");
        lblHeight.setBounds(130, 67, 40, 20);

        add(lblHeight);

        this.txtHeight = new JTextField();
        txtHeight.setHorizontalAlignment(SwingConstants.CENTER);
        txtHeight.setBounds(105, 87, 90, 20);

        add(txtHeight);

        this.btnChangeFile = new JButton("Alterar");
        btnChangeFile.addActionListener(new ButtonChangeResizeEvent(txtFile, txtWidth, txtHeight));
        btnChangeFile.setBounds(105, 112, 90, 20);

        add(btnChangeFile);
    }

}