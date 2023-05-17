package com.example.teamprojectmusicandpainting;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainView {

    public String musicDirectoryPath = "src/main/java/Music";
    public TableView musicTableView;
    public TableColumn<String, String> musicNameColumn;
    public TableColumn musicDurationColumn;

    private Media media;
    private MediaPlayer mediaPlayer;
    private String musicTitleToPlay = "";

    public List<File> getAllMusic(){
        List<File> musicListFiles = new ArrayList<>();
        File musicDirectory = new File(musicDirectoryPath);
        if (musicDirectory.isDirectory()) {
            File[] files = musicDirectory.listFiles();
            if (files != null) {
                for (File file : files){
                    if (file.isFile())
                        musicListFiles.add(file);
                    }
                }
            }
        return musicListFiles;
    }


    // vreai sa iau infromatia pe baza clickului iar apoi sa pot da play pe baza acestei informatii
    public void getSelectedMusic(){
        musicTableView.setOnMouseClicked(event -> {
            int rowIndex = musicTableView.getSelectionModel().getSelectedIndex();

            // Accesăm prima coloană și valoarea ei
            TableColumn<String, String> firstColumn = (TableColumn<String, String>) musicTableView.getColumns().get(0);
            musicTitleToPlay = firstColumn.getCellData(rowIndex);

        });
    }

    //parcugrem melodiile si cand gasim pe cea selectata ii dam play
    public void playSelectetSong(){
        File musicDirectory = new File(musicDirectoryPath);
        if (musicDirectory.isDirectory()) {
            File[] files = musicDirectory.listFiles();
            if (files != null) {
                for (File file : files){
                    if (file.getName().equals(musicTitleToPlay)){
                        media = new Media(file.toURI().toString());
                        mediaPlayer = new MediaPlayer(media);
                        mediaPlayer.play();
                    }
                }
            }
        }
    }


    public void handleShowMusic() {
        List<File> musicListFile = getAllMusic();
        List<String> musicNames = new ArrayList<>();
        for (File file : musicListFile) {
            musicNames.add(file.getName());
            System.out.println(file.getName());
        }

        ObservableList<String> musicListData = FXCollections.observableArrayList(musicNames);

        musicNameColumn = new TableColumn<>("Music Name");
        musicNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()));
        musicTableView.getColumns().setAll(musicNameColumn);
        musicTableView.setItems(musicListData);



        getSelectedMusic();
    }



}
