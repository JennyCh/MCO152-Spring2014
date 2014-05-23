package charnetskaya.earthquakes;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

public class BuildLabels extends Thread {


private JPanel label;
	private JList <Data> jList;
	private JFrame frame;
	private DataList data;
	private JPanel[] labels;
	private String [] array;
	//private int numLabels = 0;
	
	public BuildLabels(JFrame frame, DataList data){
	
	//	this.jList = new <JLabel>JList();
		this.data = data;
		this.frame = frame;
		this.array = array;
	}
	
	public void run(){
		//labels = new JPanel[data.size()];
		
		for(int i = 0; i < data.size(); i++){
			label = new JPanel();
			label.add(new JLabel(data.get(i).location));
			label.setBackground(Color.green);
			//labels[i] = label;
		}
		
		MyCellRenderer render = new MyCellRenderer();
		jList.
		/*for(int i = 0; i < data.size(); i++){
		render.getListCellRendererComponent(jList, array[i], 0, false, false);
		}*/
		
		
	}
	
	private class MyCellRenderer extends JLabel implements ListCellRenderer<Object> {
	     public MyCellRenderer() {
	         setOpaque(true);
	     }

	     public Component getListCellRendererComponent(JList<?> list,
	                                                   Object value,
	                                                   int index,
	                                                   boolean isSelected,
	                                                   boolean cellHasFocus) {

	         setText(value.toString());

	         Color background;
	         Color foreground;

	         // check if this cell represents the current DnD drop location
	         JList.DropLocation dropLocation = list.getDropLocation();
	         if (dropLocation != null
	                 && !dropLocation.isInsert()
	                 && dropLocation.getIndex() == index) {

	             background = Color.BLUE;
	             foreground = Color.WHITE;

	         // check if this cell is selected
	         } else if (isSelected) {
	             background = Color.RED;
	             foreground = Color.WHITE;

	         // unselected, and not the DnD drop location
	         } else {
	             background = Color.WHITE;
	             foreground = Color.BLACK;
	         };

	         setBackground(background);
	         setForeground(foreground);

	         return this;
	     }
	 }
}
