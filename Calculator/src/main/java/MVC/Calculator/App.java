package MVC.Calculator;

/**
 * @naomijub for Two2Year2Engagement
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       View view = new View();
       Model model = new Model();
       Controller controller = new Controller(view, model);
       if(view.getAnswer()){
    	   controller.operate();
       }
    	   
       view.setTitle("MVCCalculator@naomijub");
       view.setSize(600, 600);
       view.setLocation(400, 170);
       view.pack();
       view.setResizable(false);
       view.setVisible(true);
    }
}
