package pascalGO.gui;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JMenuItem;

public class Interface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel ContentPanel = null;
	private JMenuBar menu = null;
	private JMenu fileMenu = null;
	private JPanel actionPanel = null;
	private JButton compileButton = null;
	private JPanel sourcePanel = null;
	private JScrollPane sourceScrollPane = null;
	private JTextArea sourceTextArea = null;
	private JMenuItem openFileMenuItem = null;
	/**
	 * This is the default constructor
	 */
	public Interface() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(629, 277);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(getContentPanel());
		this.setJMenuBar(getMenu());
		this.setTitle("PascalGO");
	}

	/**
	 * This method initializes ContentPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getContentPanel() {
		if (ContentPanel == null) {
			BorderLayout borderLayout = new BorderLayout();
			borderLayout.setHgap(5);
			borderLayout.setVgap(5);
			ContentPanel = new JPanel();
			ContentPanel.setLayout(borderLayout);
			ContentPanel.add(getActionPanel(), BorderLayout.SOUTH);
			ContentPanel.add(getSourcePanel(), BorderLayout.CENTER);
		}
		return ContentPanel;
	}

	/**
	 * This method initializes menu	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getMenu() {
		if (menu == null) {
			menu = new JMenuBar();
			menu.add(getFileMenu());
		}
		return menu;
	}

	/**
	 * This method initializes fileMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getFileMenu() {
		if (fileMenu == null) {
			fileMenu = new JMenu();
			fileMenu.setText("Files");
			fileMenu.add(getOpenFileMenuItem());
		}
		return fileMenu;
	}

	/**
	 * This method initializes actionPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getActionPanel() {
		if (actionPanel == null) {
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridy = 0;
			gridBagConstraints1.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints1.gridx = 0;
			actionPanel = new JPanel();
			actionPanel.setLayout(new GridBagLayout());
			actionPanel.add(getCompileButton(), gridBagConstraints1);
		}
		return actionPanel;
	}

	/**
	 * This method initializes compileButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getCompileButton() {
		if (compileButton == null) {
			compileButton = new JButton();
			compileButton.setText("Compile");
		}
		return compileButton;
	}

	/**
	 * This method initializes sourcePanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getSourcePanel() {
		if (sourcePanel == null) {
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.fill = GridBagConstraints.BOTH;
			gridBagConstraints.gridy = 0;
			gridBagConstraints.weightx = 1.0;
			gridBagConstraints.weighty = 1.0;
			gridBagConstraints.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints.gridwidth = 1;
			gridBagConstraints.ipadx = 2;
			gridBagConstraints.ipady = 2;
			gridBagConstraints.gridx = 0;
			sourcePanel = new JPanel();
			sourcePanel.setLayout(new GridBagLayout());
			sourcePanel.add(getSourceScrollPane(), gridBagConstraints);
		}
		return sourcePanel;
	}

	/**
	 * This method initializes sourceScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getSourceScrollPane() {
		if (sourceScrollPane == null) {
			sourceScrollPane = new JScrollPane();
			sourceScrollPane.setBorder(BorderFactory.createTitledBorder(null, "Source:", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			sourceScrollPane.setViewportView(getSourceTextArea());
		}
		return sourceScrollPane;
	}

	/**
	 * This method initializes sourceTextArea	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getSourceTextArea() {
		if (sourceTextArea == null) {
			sourceTextArea = new JTextArea();
		}
		return sourceTextArea;
	}

	/**
	 * This method initializes openFileMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getOpenFileMenuItem() {
		if (openFileMenuItem == null) {
			openFileMenuItem = new JMenuItem();
			openFileMenuItem.setText("Open");
		}
		return openFileMenuItem;
	}

}  //  @jve:decl-index=0:visual-constraint="15,36"
