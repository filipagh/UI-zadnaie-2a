package ai;


import javafx.application.*;

import javafx.scene.Scene;
import javafx.scene.control.*;

import objekty.PrvaGeneraciaStanice;
import objekty.TretiaGeneraciaStanice;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import objekty.CentralnySklad;
import objekty.CerpaciaStanica;
import objekty.DialnicnaGeneraciaStanice;
import objekty.DruhaGeneraciaStanice;

public class GUI extends Application {

	private static final CerpaciaStanica PrvaGeneraciaStanice = null;

	AI ai;

	
	private static TextArea vypis;
	
	static public void Napis(String str)
	{
		vypis.appendText(str+"\n");
	}
	
	
	public static void main (String[] args)
	{	
		launch(args);
		
	
	}
	
	public void start(Stage formular)  {
		formular.setTitle("logistika");
		ai = new AI();
		FlowPane pane = new FlowPane();
		
		
		
		Button cyklus = new Button("1 den");
		Button pridajcentsklad = new Button("vyrob centralny sklad");
		TextField nazov = new TextField();
		
		ChoiceBox<CentralnySklad> centralneskladyzoznam = new ChoiceBox();
		Label Nazovtext = new Label(" <- tu zadaj Nazov");
		Label oddelovac = new Label("|        |");
		
		ChoiceBox<String> cerpaciastanicazvol = new ChoiceBox();
		Button cerpaciastanica = new Button("vytvor CS");
		
		
		vypis = new TextArea();
		ScrollPane skrolVypis = new ScrollPane(vypis);
	
		Button raf = new Button("Report Rafineria");
		
		ChoiceBox<String> upgrade = new ChoiceBox();
		Button nadrz = new Button("Nadrz");
		Button vyroba = new Button("Vyrobna linka");
		
		
	
		
		
	
		pane.getChildren().add(cyklus);
		pane.getChildren().add(pridajcentsklad);
		pane.getChildren().add(nazov);
		pane.getChildren().add(Nazovtext);
		pane.getChildren().add(centralneskladyzoznam);
		pane.getChildren().add(oddelovac);
		pane.getChildren().add(cerpaciastanicazvol);
		pane.getChildren().add(cerpaciastanica);
		pane.getChildren().add(skrolVypis);
		pane.getChildren().add(raf);
		pane.getChildren().add(upgrade);
		pane.getChildren().add(nadrz);
		pane.getChildren().add(vyroba);
		
		
		upgrade.getItems().add("benzin");
		upgrade.getItems().add("benzinplus");
		upgrade.getItems().add("nafta");
		upgrade.getItems().add("naftaplus");
		
		cerpaciastanicazvol.getItems().add("Prva Generacia");
		cerpaciastanicazvol.getItems().add("Druha Generacia");
		cerpaciastanicazvol.getItems().add("Tretia Generacia");
		cerpaciastanicazvol.getItems().add("Dialnicna Cerpacia stanica");
		
		formular.setScene(new Scene(pane, 830, 400));
		formular.show();
		
		nadrz.setOnAction(e -> {
			
				if (upgrade.getValue()=="benzin")
				{
					ai.raf.getBenzin().setMax_velkost(   (ai.raf.getBenzin().getMax_velkost()+200000 ));
				}
				if (upgrade.getValue()=="benzinplus")
				{
					ai.raf.getBenzinplus().setMax_velkost(  (ai.raf.getBenzinplus().getMax_velkost()+200000 ));
				}
				if (upgrade.getValue()=="nafta")
				{
					ai.raf.getNafta().setMax_velkost(  (ai.raf.getNafta().getMax_velkost()+200000 ));
				}
				if (upgrade.getValue()=="naftaplus")
				{
					ai.raf.getNaftaplus().setMax_velkost(  (ai.raf.getNaftaplus().getMax_velkost()+200000 ));
				}
				
				Napis("Skladove miesto rozsirene");
			});
		
		vyroba.setOnAction(e -> {
			
			if (upgrade.getValue()=="benzin")
			{
				ai.raf.getBenzin().setMax_vyroba(ai.raf.getBenzin().getMax_vyroba()+20000);
			}
			if (upgrade.getValue()=="benzinplus")
			{
				ai.raf.getBenzinplus().setMax_vyroba(ai.raf.getBenzinplus().getMax_vyroba()+20000);
			}
			if (upgrade.getValue()=="nafta")
			{
				ai.raf.getNafta().setMax_vyroba(ai.raf.getNafta().getMax_vyroba()+20000);
			}
			if (upgrade.getValue()=="naftaplus")
			{
				ai.raf.getNaftaplus().setMax_vyroba(ai.raf.getNaftaplus().getMax_vyroba()+20000);
			}
			
			Napis("Vyrobna linka rozsirena");
		});
		
		raf.setOnAction(e -> {
		 ai.raf.report();
			
		});
		
		cyklus.setOnAction(e -> {
			vypis.clear();
			ai.mainn();
		});
		
		pridajcentsklad.setOnAction(e -> {
			CentralnySklad pom = new CentralnySklad(nazov.getText());
			ai.pridajcentralnysklad(pom);
			centralneskladyzoznam.getItems().add(pom);
			
			Napis("Centralny Sklad vytvoreny");
		});
		
		
		
	
	//	cerpaciastanicazvol.getv
		
		
		
		
		cerpaciastanica.setOnAction(e -> 
		{
			
			if (cerpaciastanicazvol.getValue() == "Prva Generacia")
			{
			ai.pridajcerpaciustanicu(new PrvaGeneraciaStanice(nazov.getText(),1,centralneskladyzoznam.getValue(),ai.getSledovatelia()));
			}
			if (cerpaciastanicazvol.getValue() == "Druha Generacia")
			{
			ai.pridajcerpaciustanicu(new DruhaGeneraciaStanice(nazov.getText(),2,centralneskladyzoznam.getValue(),ai.getSledovatelia()));
			}if (cerpaciastanicazvol.getValue() == "Tretia Generacia")
			{
			ai.pridajcerpaciustanicu(new TretiaGeneraciaStanice(nazov.getText(),3,centralneskladyzoznam.getValue(),ai.getSledovatelia()));
			}if (cerpaciastanicazvol.getValue() == "Dialnicna Cerpacia stanica")
			{
			ai.pridajcerpaciustanicu(new DialnicnaGeneraciaStanice(nazov.getText(),4,centralneskladyzoznam.getValue(),ai.getSledovatelia()));
			}
		
			Napis("Cerpacia stanica pridana;");
			
		});
		
	
		
		
	}
	
	
}
