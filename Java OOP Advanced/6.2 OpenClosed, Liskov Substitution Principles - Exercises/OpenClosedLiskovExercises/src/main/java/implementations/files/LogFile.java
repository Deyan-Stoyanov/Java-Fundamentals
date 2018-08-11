package implementations.files;

import abstractions.File;

public class LogFile implements File {
    StringBuilder sb;

    public LogFile() {
        sb = new StringBuilder();
    }

    public void write(String message){
        sb.append(message);
    }

    public long getSize(){
        long size = 0;
        for (int i = 0; i < sb.length(); i++) {
			if(String.valueOf(sb.charAt(i)).matches("[a-zA-Z]")){
				size += sb.charAt(i);
			}
        }
        return size;
    }
}
