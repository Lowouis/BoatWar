package controler;
import modele.*;
public class Controler {

	private View views;
	private Model model;
	
	public Controler(Model model, View views){
		this.model = model;
		this.views = views;
	}
	
	public void orchestrator(){
		Model m = new Model();
	}
	
	public Model getModel(){
		return this.model;
	}
	
	
	
	
	
}

