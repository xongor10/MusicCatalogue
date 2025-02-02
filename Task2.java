import javax.swing.*;
import java.awt.*;

public class MusicCatalogue {
    JFrame frame;
    JButton B1, B2;
    JList<String> list;
    JTextField artistField, studioField;
    JComboBox<String> categoryBox;
    JCheckBox availableCheck;

    public MusicCatalogue() {
        JFrame frame = new JFrame("BorderLayout");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        frame.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("My Music Catalogue", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(titleLabel, BorderLayout.NORTH);

        String[] categories = {"Rap", "Reggae", "Ballads"};
        list = new JList<>(categories);
        frame.add(new JScrollPane(list), BorderLayout.WEST);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 2, 5, 5));

        formPanel.add(new JLabel("Artist Name:"));
        artistField = new JTextField();
        formPanel.add(artistField);

        formPanel.add(new JLabel("Recording Studio:"));
        studioField = new JTextField();
        formPanel.add(studioField);

        formPanel.add(new JLabel("Category:"));
        categoryBox = new JComboBox<>(categories);
        formPanel.add(categoryBox);

        formPanel.add(new JLabel("Available:"));
        availableCheck = new JCheckBox();
        formPanel.add(availableCheck);

        frame.add(formPanel, BorderLayout.CENTER);

        JPanel panelSouth = new JPanel();
        panelSouth.add(prepareB1());
        panelSouth.add(prepareB2());

        frame.add(panelSouth, BorderLayout.SOUTH);

        B1.addActionListener(e -> {
            String artistName = artistField.getText();
            String studioName = studioField.getText();
            String category = (String) categoryBox.getSelectedItem();
            boolean available = availableCheck.isSelected();

            System.out.println("Artist Name: " + artistName);
            System.out.println("Recording Studio: " + studioName);
            System.out.println("Category: " + category);
            System.out.println("Available: " + available);
        });

        B2.addActionListener(e -> System.exit(0));

        frame.setVisible(true);

    }

    public JButton prepareB1() {
        B1 = new JButton("Submit");
        return B1;
    }

    public JButton prepareB2() {
        B2 = new JButton("Exit");
        return B2;
    }

}
public class Main {
    public static void main(String[] args){
        new MusicCatalogue();
    }
}
