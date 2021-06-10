package FileTools;

import android.os.Bundle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SaveRoleOfBundle {
    public boolean save(FileOutputStream fos, Bundle bundle) {
        OutputStreamWriter streamWriter = new OutputStreamWriter(fos);
        BufferedWriter writer = new BufferedWriter(streamWriter);
        try {
            writer.write(bundle.getString("tag")+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
