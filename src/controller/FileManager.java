package controller;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class FileManager {

    private final String LOAD_PATH="image/fileopen.png";
    private final String SAVE_PATH="image/filesave.png";
    private final String SAVE_AS_PATH="image/SaveAs.png";


    private BufferedImage imageLoad;
    private BufferedImage imageSave;
    private BufferedImage imageSaveAs;

    private File file;

    public FileManager() {
        this.file = new File(System.getProperty("user.home"));

        try {
            imageLoad = ImageIO.read(new File(LOAD_PATH));
            imageSave = ImageIO.read(new File(SAVE_PATH));
            imageSaveAs = ImageIO.read(new File(SAVE_AS_PATH));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public String readFile() {
        String line;
        String aux = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(this.file))) {
            while ((line = bufferedReader.readLine()) != null) {
                aux += line + "\n";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return aux;
    }

    public void writeFile(String text) {
        try (BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(this.file))) {
            bufferWriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public BufferedImage getImageLoad() {
        return imageLoad;
    }

    public void setImageLoad(BufferedImage imageLoad) {
        this.imageLoad = imageLoad;
    }

    public BufferedImage getImageSave() {
        return imageSave;
    }

    public void setImageSave(BufferedImage imageSave) {
        this.imageSave = imageSave;
    }

    public BufferedImage getImageSaveAs() {
        return imageSaveAs;
    }

    public void setImageSaveAs(BufferedImage imageSaveAs) {
        this.imageSaveAs = imageSaveAs;
    }
}