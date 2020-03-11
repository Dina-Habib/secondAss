/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectionjavafx;


import java.util.List;
import java.util.stream.Collectors;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author dinahabib
 */
public class SelectionjavaFX extends Application {
    private ListView listViewItems,listViewSelected;
    private Button copyButton;
    
    
    @Override
    public void start(Stage primaryStage) throws Exception{
      listViewItems=new ListView();
      listViewItems.getItems().add("Dina");
      listViewItems.getItems().add("Sara");
      listViewItems.getItems().add("Soad");
      listViewItems.getItems().add("Nada");
      listViewItems.getItems().add("Omar");
      listViewItems.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
      listViewSelected=new ListView();
      copyButton=new Button("Copy >>>");
      EventHandler1 ev1=new EventHandler1();
      copyButton.addEventHandler(MouseEvent.MOUSE_CLICKED, ev1);
      HBox hbox=new HBox(10);
      hbox.getChildren().addAll(listViewItems,copyButton,listViewSelected);
      hbox.setAlignment(Pos.CENTER);
      hbox.setStyle("-fx-background-color:lightGray");
      Scene scene = new Scene(hbox,400,400);
      primaryStage.setTitle("ListView JavaFX App");
      primaryStage.setScene(scene);
      primaryStage.setResizable(false);
      primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    private class EventHandler1 implements EventHandler<Event>{

        @Override
        public void handle(Event event) {
            if(event.getSource()==copyButton){
                if(!listViewItems.getSelectionModel().isEmpty()){
                    List list=listViewItems.getSelectionModel().getSelectedItems();
                    listViewSelected.getItems().setAll(list);
                }else{
                    Alert alert=new Alert(AlertType.INFORMATION);
                    alert.setTitle("Alert window");
                    alert.setHeaderText(null);
                    alert.setContentText("There is no item to added");
                    alert.showAndWait();
                }
            }
        }
        
    }   
}
