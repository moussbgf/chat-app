package dta.chat.view.console;

import java.util.ArrayList;
import java.util.List;

public abstract class ViewComposite {

	private List<ViewComposite> children = new ArrayList<ViewComposite>();
	
	protected void add(ViewComposite child) {
		
		this.children.add(child);
		
	}
	
	public abstract void printBefore();
	
	public void print() {
		
		printBefore();
		
		children.forEach((child) -> child.print());
//		ou :
		
//		children.forEach(ViewComposite::print());
	}

}