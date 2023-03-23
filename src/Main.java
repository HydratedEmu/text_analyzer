import javafx.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/*
 * 
 * 
 * */

//import application.FileReader2;

public class Main extends Application {

	static TextArea ta = new TextArea();
	static TextField webLink = new TextField();
	@Override
	public void start(Stage stage) throws Exception {

		try {

			// Creating a Grid Pane
			GridPane gridPane = new GridPane();

			// Setting the vertical and horizontal gaps between the columns
			gridPane.setVgap(5);
			gridPane.setHgap(5);
			
			// Setting size for the pane
			gridPane.setMinSize(400, 200);
			//Setting the Grid alignment 
		    gridPane.setAlignment(Pos.CENTER); 
			// Setting the padding
			gridPane.setPadding(new Insets(10, 10, 10, 10));
			// Creating a scene object
			Scene scene = new Scene(gridPane);
			
			// Adding scene to the stage
			stage.setScene(scene);
			stage.setWidth(420);
			stage.setHeight(420);
			

			stage.setTitle("JSoup WebScraper");
			
			
			Label label1 = new Label("Enter Link to be scraped:");
			TextField webLink = new TextField();
			
			ta.setMaxHeight(400);
			ta.setMaxWidth(200);
			
			//buttons
			Button runBtn = new Button("RUN SCRAPER");
			
			// action event
			EventHandler<ActionEvent> runBtnEvent = new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					try {
						ta.setText(Main1.wordMain(webLink.getText()));
					} catch (Exception e1) {
						
						e1.printStackTrace();
					}
					
					}
			};
			
			runBtn.setOnAction(runBtnEvent);
			
			
			HBox hb = new HBox();
			hb.getChildren().addAll(label1, webLink, runBtn, ta);
			hb.setSpacing(15);
			
			// organize Grid Pane			
			gridPane.add(label1, 0, 0);
			gridPane.add(webLink, 0, 1);
			gridPane.add(hb, 0, 2);
			
			
			stage.show();
			stage.setResizable(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {

		launch(args);	
	}
}

class C2 implements Comparator<Item> {

	@Override
	public int compare(Item o1, Item o2) {
		if (o1.count < o2.count) {
			return 1;
		}
		return -1;
	}

}