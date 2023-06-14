import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class NoThreadFileExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("No Thread File Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 500);

            Container container = frame.getContentPane();
            container.setLayout(new FlowLayout());

            JButton button = new JButton("Load File");
            JTextArea textArea = new JTextArea(5, 30);
            JTextArea textArea1 = new JTextArea(5, 30);
            JScrollPane scrollPane = new JScrollPane(textArea);
            JScrollPane scrollPane1 = new JScrollPane(textArea1);

            button.addActionListener(e -> {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(frame);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    textArea.setText("Loading...");
                    try {
                        readFile(selectedFile, textArea);
                    } catch (IOException ex) {
                        textArea.setText("Error reading file");
                    }
                }
            });

            container.add(button);
            container.add(scrollPane);
            container.add(scrollPane1);

            frame.setVisible(true);
        });
    }

    private static void readFile(File file, JTextArea textArea) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            StringBuilder buffer = new StringBuilder();
            String line;
            Random random = new Random();

            textArea.setText("");

            while ((line = br.readLine()) != null) {
                String upperCaseLine = line.toUpperCase();
                StringBuilder modifiedLine = new StringBuilder();

                // Wstawianie losowej liczby po każdej literze
                for (char c : upperCaseLine.toCharArray()) {
                    modifiedLine.append(c).append(random.nextInt(10));
                }

                buffer.append(modifiedLine).append("\n");
            }

            textArea.setText(buffer.toString());
        }
    }
}