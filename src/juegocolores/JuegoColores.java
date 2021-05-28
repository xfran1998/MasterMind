/*0
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegocolores;

import informacion.view.InformacionView;
import ini.view.JuegoColoresView;
import juegocolores.controller.MastermindController;
import juegocolores.model.MastermindModel;
import jug1.view.Jug1View;
import jug2.view.Jug2View;
import ranking.view.RankingView;

/**
 *
 * @author oscar
 * @author francisco
 */
public class JuegoColores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        MastermindModel model = new MastermindModel();
        JuegoColoresView view = new JuegoColoresView();
        MastermindController controller = new MastermindController(view, model);
        
        //Jug1View view = new Jug1View();
        //Jug2View view = new Jug2View();
        //RankingView view = new RankingView(1);
        //InformacionView view = new InformacionView();
    }
    
}
