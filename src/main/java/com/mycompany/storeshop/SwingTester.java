package com.mycompany.storeshop;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;

public class SwingTester extends javax.swing.JFrame {
    JButton button;
    JPanel panel;

    public static void main(String[] args) {
    }

    public void uploadFile(String image_name){
        JFileChooser fc = new JFileChooser();
        int result = fc.showOpenDialog(null);
//        image_name = String.valueOf((Integer.parseInt(image_name) + 1));

// Make sure that a file was chosen, else exit
        if (result != JFileChooser.APPROVE_OPTION) {
            System.exit(0);
        }

// Get file path
        String path = fc.getSelectedFile().getAbsolutePath();

// Create folder "images" (variable success will be true if a folder was created and false if it did not)
        File folder = new File("src/main/java/com/mycompany/storeshop/images");
        boolean success = folder.mkdir();
// Get the destination of the folder and the new image (image.jpg will be the new name)
        String destination = folder.getAbsolutePath() + File.separator + image_name + ".png";

        try {
            // Copy file from source to destination
            FileChannel source = new FileInputStream(path).getChannel();
            FileChannel dest = new FileOutputStream(destination).getChannel();
            dest.transferFrom(source, 0, source.size());

            // Close shit
            source.close();
            dest.close();

            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean windowShow(){
        ConnectDB test = new ConnectDB();
        setTitle("Upload image");
        setSize(350, 100);

        // Create JButton and JPanel
        button = new JButton("Upload image");
        panel = new JPanel();

        // Add button to JPanel
        panel.add(button);
        // And JPanel needs to be added to the JFrame itself!
        this.getContentPane().add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button){
                    uploadFile(test.rowCount());
                }
            }
        });
        return true;
    }

    public static void createWindow() {
        JFrame frame = new JFrame("Upload image");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        createUI(frame);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void createUI(final JFrame frame){
        JPanel panel = new JPanel();
        LayoutManager layout = new FlowLayout();
        panel.setLayout(layout);
        JButton button = new JButton("Add images");
        final JLabel label = new JLabel();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.addChoosableFileFilter(new ImageFilter());
                fileChooser.setAcceptAllFileFilterUsed(false);
                int option = fileChooser.showOpenDialog(frame);
                if(option == JFileChooser.APPROVE_OPTION){
                    File file = fileChooser.getSelectedFile();
                    label.setText("File Selected: " + file.getName());
                    System.out.println(file);
                }else{
                    label.setText("Open command canceled");
                }
            }
        });

        panel.add(button);
        panel.add(label);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
    }
}

class ImageFilter extends FileFilter {
    public final static String JPEG = "jpeg";
    public final static String JPG = "jpg";
    public final static String GIF = "gif";
    public final static String TIFF = "tiff";
    public final static String TIF = "tif";
    public final static String PNG = "png";

    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        String extension = getExtension(f);
        if (extension != null) {
            if (extension.equals(TIFF) ||
                    extension.equals(TIF) ||
                    extension.equals(GIF) ||
                    extension.equals(JPEG) ||
                    extension.equals(JPG) ||
                    extension.equals(PNG)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public String getDescription() {
        return "Image Only";
    }

    String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }
}
