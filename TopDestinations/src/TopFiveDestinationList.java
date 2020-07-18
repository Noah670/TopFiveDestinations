import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class TopFiveDestinationList {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	TopDestinationListFrame topDestinationListFrame = new TopDestinationListFrame();
                topDestinationListFrame.setTitle("Top 5 Destination List Noah Pohl");
                topDestinationListFrame.setVisible(true);
           
              
            }
        });
    }
}


class TopDestinationListFrame extends JFrame {
    private DefaultListModel listModel;

    public TopDestinationListFrame() {
        super("Top Five Destination List");
        
   
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(900, 750);

        listModel = new DefaultListModel();
        
        // Create a new label to be displayed at the top of the page
        JLabel myName = new JLabel("  Noah Pohl © 2020");
        // set bounds to be displayed
		myName.setBounds(200, 0, 300, 100);
		getContentPane().add(myName);
		
		

        // Travel Destinations that are cool
        addDestinationNameAndPicture("1. Tokyo, Japan: An amazing city where tradition and the ultramodern blend together ! (Tokyo Tower)", new ImageIcon(getClass().getResource("/resources/tokyo.jpg")));
        addDestinationNameAndPicture("2. Amsterdam, Netherlands: A city filled with history, culture, tulips and windmills. (Rijksmuseum museum)", new ImageIcon(getClass().getResource("/resources/amsterdam.jpg")));
        addDestinationNameAndPicture("3. Bangkok, Thailand: Come taste the best street food in the world and visit the Grand palace. (Tourism Thailand)", new ImageIcon(getClass().getResource("/resources/bangkok.jpg")));
        addDestinationNameAndPicture("4. Guam, USA the island where America's day begins. (BBC News) ", new ImageIcon(getClass().getResource("/resources/guam.jpg")));
        addDestinationNameAndPicture("5. Interlaken, Switzerland: Home to breathtaking mountain ranges and crystal clear lakes (Switzerland Tour).", new ImageIcon(getClass().getResource("/resources/interlacken.jpg")));
        
        JList list = new JList(listModel);
        JScrollPane scrollPane = new JScrollPane(list);

        TextAndIconListCellRenderer renderer = new TextAndIconListCellRenderer(2);

        list.setCellRenderer(renderer);
        
        // Change the background color of the page 
        list.setBackground(Color.LIGHT_GRAY);
        
  
        

        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    private void addDestinationNameAndPicture(String text, Icon icon) {
        TextAndIcon tai = new TextAndIcon(text, icon);
        listModel.addElement(tai);
    }
}


class TextAndIcon {
    private String text;
    private Icon icon;

    public TextAndIcon(String text, Icon icon) {
        this.text = text;
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }
}


class TextAndIconListCellRenderer extends JLabel implements ListCellRenderer {
    private static final Border NO_FOCUS_BORDER = new EmptyBorder(1, 1, 1, 1);

    private Border insideBorder;

    public TextAndIconListCellRenderer() {
        this(0, 0, 0, 0);
    }

    public TextAndIconListCellRenderer(int padding) {
        this(padding, padding, padding, padding);
    }

    public TextAndIconListCellRenderer(int topPadding, int rightPadding, int bottomPadding, int leftPadding) {
        insideBorder = BorderFactory.createEmptyBorder(topPadding, leftPadding, bottomPadding, rightPadding);
        setOpaque(true);
    }

    public Component getListCellRendererComponent(JList list, Object value,
    int index, boolean isSelected, boolean hasFocus) {
        // The object from the combo box model MUST be a TextAndIcon.
        TextAndIcon tai = (TextAndIcon) value;

        // Sets text and icon on 'this' JLabel.
        setText(tai.getText());
        setIcon(tai.getIcon());

        
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        

        Border outsideBorder;

        if (hasFocus) {
            outsideBorder = UIManager.getBorder("List.focusCellHighlightBorder");
        } else {
            outsideBorder = NO_FOCUS_BORDER;
        }

        setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));
        setComponentOrientation(list.getComponentOrientation());
        setEnabled(list.isEnabled());
        setFont(list.getFont());

        return this;
    }

    // Methods to Override

    public void validate() {}
    public void invalidate() {}
    public void repaint() {}
    public void revalidate() {}
    public void repaint(long tm, int x, int y, int width, int height) {}
    public void repaint(Rectangle r) {}
}
