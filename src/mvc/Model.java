package mvc;

import java.io.Serializable;

public class Model extends Publisher implements Serializable {
    private boolean unsavedChanges = false;
    private String fileName = null;

    public void changed(){
        unsavedChanges = true;
        notifySubscribers();
    }
    public String getFileName() {return fileName;}
    public void setFileName(String s) {fileName = s;}
    public boolean getUnsavedChanges() {return unsavedChanges;}
    public void setUnsavedChanges(boolean b) {unsavedChanges = b;}
}
