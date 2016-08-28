
//Console.java

package PsychoGame;

import PsychoSystem.FileLoader;
import java.awt.event.KeyEvent;
import java.util.HashMap;
//import java.util.LinkedList;
import java.util.Random;
import java.util.StringTokenizer;

//  PsySoft Team 2008
//       (Manuel Espinoza, Alberto Zorrilla, Guillermo Leon y Arquimides Diaz)

public class Console extends javax.swing.JFrame {
  
  private static String hackerName=Engine.selectedProfile, email="";
  public static HashMap<String,Integer> cmdList = new HashMap();
  //private static LinkedList<String> emails = new LinkedList();
  public static boolean cd=false,sd=false,floppy=false, gotemail=false, notify=false, challenge=false;
  private int n;
    
    public Console() {
       initComponents();
       cmdList.put("exit", 1);
       cmdList.put("install", 2);
       cmdList.put("ping", 3);
       cmdList.put("ftp", 4);
       cmdList.put("readmail", 5);
       cmdList.put("save",6);
       cmdList.put("help", 99);
       outputArea.append(banner());
       inputArea.grabFocus();
       printOut("\n\nEsta es la consola, es de gran utilidad. Teclea \"help\" para ver los comandos disponibles.\n" +
               "Con el comando \"readmail\" puedes leer los mails que te enviemos.");
       }
   
   public void clearInput(){        
        inputArea.setText("");
        inputArea.grabFocus();
   }
   
   public void printOut(String s){
    outputArea.setText(outputArea.getText()+s+"\n\n"+banner());
    //notify=true;
   }
   
   public void setEmail(String sender, String s){
    gotemail=true;
       //emails.add("["+sender+"]"+s);
    email="["+sender+"]"+s;
    outputArea.setText(outputArea.getText()+"\n\nYou got a new email from "+sender+"\n\n"+banner());
    notify=true;
   }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        inputArea = new javax.swing.JTextArea();

        setTitle("Console");
        setBackground(new java.awt.Color(0, 0, 0));
        setFocusable(false);
        setLocationByPlatform(true);
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setAutoscrolls(true);

        outputArea.setBackground(new java.awt.Color(0, 0, 0));
        outputArea.setColumns(20);
        outputArea.setEditable(false);
        outputArea.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        outputArea.setForeground(new java.awt.Color(102, 255, 0));
        outputArea.setLineWrap(true);
        outputArea.setRows(5);
        outputArea.setText("Checking Synaptic BIOS....\nBIOS Loaded, Booting......\n\n============================\nBioBox Kernel 2.6.99-EEG\n============================\nLoading BioConfiguration #14121\n\nChecking Nervous input..... OK\nChecking Optical output....... OK\nChecking Sound Nervous output........ OK\nChecking Vital Signs............ OK  \n\n> Type \"help\" to see available commands\n");
        outputArea.setWrapStyleWord(true);
        outputArea.setAutoscrolls(true);
        outputArea.setCaretColor(new java.awt.Color(102, 255, 0));
        outputArea.setSelectedTextColor(new java.awt.Color(255, 0, 0));
        outputArea.setSelectionColor(new java.awt.Color(255, 255, 255));
        outputArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                outputAreaMouseClicked(evt);
            }
        });
        outputArea.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                outputAreaFocusGained(evt);
            }
        });
        outputArea.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                outputAreaPropertyChange(evt);
            }
        });
        outputArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                outputAreaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(outputArea);

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        inputArea.setBackground(new java.awt.Color(0, 0, 0));
        inputArea.setColumns(20);
        inputArea.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        inputArea.setForeground(new java.awt.Color(102, 255, 0));
        inputArea.setRows(1);
        inputArea.setAutoscrolls(true);
        inputArea.setCaretColor(new java.awt.Color(102, 255, 0));
        inputArea.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputAreaFocusLost(evt);
            }
        });
        inputArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputAreaKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(inputArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void outputAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_outputAreaKeyPressed
       
}//GEN-LAST:event_outputAreaKeyPressed

private void inputAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputAreaKeyPressed
  if (evt.getKeyCode() == KeyEvent.VK_ENTER){
    String aux = inputArea.getText(); aux.toLowerCase();
    inputArea.setText("");
    outputArea.setText(outputArea.getText()+" "+aux);
    checkCmd(aux);
    outputArea.grabFocus();
    inputArea.grabFocus();
  }
  if(evt.getKeyCode() == KeyEvent.VK_ESCAPE){
      this.setVisible(false);
  }
}//GEN-LAST:event_inputAreaKeyPressed

private String banner(){
  return hackerName+"@Bi0b0x[~] $> ";
}

private void outputAreaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_outputAreaPropertyChange
  inputArea.setText("");
}//GEN-LAST:event_outputAreaPropertyChange

private void inputAreaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputAreaFocusLost
  inputArea.setText("");
}//GEN-LAST:event_inputAreaFocusLost

private void outputAreaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_outputAreaFocusGained
  inputArea.grabFocus();
}//GEN-LAST:event_outputAreaFocusGained

private void outputAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outputAreaMouseClicked
  inputArea.grabFocus();
}//GEN-LAST:event_outputAreaMouseClicked

private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
}//GEN-LAST:event_formKeyPressed

public void checkCmd(String cmd){
  inputArea.grabFocus();
  String aux;
    if(cmd.equals("help")){
      outputArea.append("\n Available Commands: "+cmdList.toString()+"\n\n"+banner());
    } else if (cmd.equals("exit")){
        cmd.replaceAll("exit", "");
      hide();
      outputArea.append("\n"+banner());
    }else if (cmd.equals("exitgame")){
        cmd.replaceAll("exit", "");
        System.exit(0);
    } else if(cmd.contains("ping") && cmd.substring(0,4).equals("ping")){
      aux = cmd.replace("ping","");
      ping(aux);
    } else if(cmd.equals("clear")){
      clear();
    } else if(cmd.contains("ftp") && cmd.substring(0,3).equals("ftp")){
      aux = cmd.replace("ftp", "");
      ftp(aux);
    }else if(cmd.contains("save")&& cmd.substring(0,4).equals("save")){
       aux=cmd.replaceAll("save", ""); 
        save(aux);
       printOut("\n saving...\n saved!!!");
    }
    else if(cmd.equals("readmail")){
      readmail();
    } else if(cmd.contains("install")&&cmd.substring(0,7).equals("install")){
      install(cmd.replace("install", ""));
    } else if(cmd.contains("sendpass")&&cmd.substring(0,8).equals("sendpass")){
      cmd=cmd.replace("sendpass", "").trim();
      if(cd){
        if(cmd.equals(toBinary(n))){
         printOut("\nBINARY execution ended, PASSWORD correct, exit status: EXIT_SUCCESS\nLEVEL1 is now UNLOCKED\n");
         cd=false; challenge=true;
         
        } else {
          outputArea.append("\nPASSWORD INCORRECT, BINARY TERMINATED\nError: reinstall to try again...\n\n"+banner());
        }
      } else {
        outputArea.append("\nNo password was being expected!\n"+banner());
      }
    }
    else {
     outputArea.append("\n Command not found...\n"+banner());
    } 
  }
  public void save(String s){
      s=s.trim();
      FileLoader.saveGame("saved/"+hackerName+"/"+s);
  }

  public void install(String s){
    s=s.trim();
    if(s.equals("binary")){
      if(cd){
      clear();
      n=binary();
      outputArea.append("\n\nInstalling BINARY challenge 0x24F....\nEXECUTING....\n\n");
      outputArea.append("La Contraseña es el numero "+n+" en binario: \nUtiliza el comando\"sendpass\"\n");
      } else {
        if(challenge){
          outputArea.append("\n\nProgram \"BINARY\" Already installed, LEVEL1 Unlocked...\n\n"+banner());
        } else {
          outputArea.append("\n\nProgram \"BINARY\" Not found...\n\n"+banner());
        }
      }
    }
  
  }

  public void setCd(boolean cd) {
    this.cd = cd;
    if(cd){
      printOut("\n\nPara instalar los datos, utiliza el comando \"install\""+
              "\nEl nombre de este programa es \"binary\"");
    }
  }
  
  public int binary(){
    Random r=new Random();
     return r.nextInt(65535);
  }

  public static String toBinary(int n){
    String aux="";
    while(n>0){
      aux=n%2+aux;
      n=n/2;
    }
    return aux;    
  }

  public void setFloppy(boolean floppy) {
    this.floppy = floppy;
  }

  public void setSd(boolean sd) {
    this.sd = sd;
  }

  public void ping(String s){
    s=s.trim();
    if (s.equals("localhost") || s.contains("127.0.0.1")){
        outputArea.setText(outputArea.getText()+"\nPING localhost (127.0.0.1) 56(84) bytes of data.\n"
                            +"64 bytes from localhost (127.0.0.1): icmp_seq=1 ttl=64 time=0.050 ms\n"
                            +"64 bytes from localhost (127.0.0.1): icmp_seq=2 ttl=64 time=0.048 ms\n"
                            +"64 bytes from localhost (127.0.0.1): icmp_seq=3 ttl=64 time=0.059 ms\n"
                            +"64 bytes from localhost (127.0.0.1): icmp_seq=4 ttl=64 time=0.052 ms\n"
                            +"--- localhost ping statistics ---"
                            +"4 packets transmitted, 4 received, 0% packet loss, time 0.2598ms"
                            +"rtt min/avg/max/mdev = 0.048/0.048/0.051/0.009 ms\n\n" + banner());
    } else if (s.equals("")){
        outputArea.setText(outputArea.getText()+"\nUsage: ping <ip or hostname>\n\n"+banner());
    } else if (s.contains(".") && checkIP(s)){      
        outputArea.setText(outputArea.getText()+
              "\nPING "+s+" ("+s+") 56(84) bytes of data.\n"+
              "From gateway ("+s+"): icmp_seq=1 Time to live exceeded\n"+
              "From gateway ("+s+"): icmp_seq=2 Time to live exceeded\n"+
              "From gateway ("+s+"): icmp_seq=3 Time to live exceeded\n"+
              "From gateway ("+s+"): icmp_seq=4 Time to live exceeded\n"+
              "--- "+s+" ping statistics --- \n"+
              "4 packets transmitted, 0 received, +4 errors, 100% packet loss, time 2999ms\n\n"+banner());
    } else {
      outputArea.setText(outputArea.getText()+"\nPING "+s+": Hostname not found or IP malformed\n\n"+banner());
    }
 }
  
  public void ftp(String s){
    if(s.equals("")){
      outputArea.setText(outputArea.getText()+"\nUsage: ftp <ip or hostname>\n\n"+banner());
    } else if(s.contains(".") && checkIP(s)){
      outputArea.setText(outputArea.getText()+"\nServer "+s+" unreachable!\n\n"+banner());
    } else {
        outputArea.setText(outputArea.getText()+"\nFTP: Hostname not found or IP malformed!\n\n"+banner());
    }
  }
  
  public boolean checkIP(String s){
    s=s.trim();
    StringTokenizer st = new StringTokenizer(s,".");
    int aux=0;
    boolean[] omfg=new boolean[4];
    if(st.countTokens()!=4)
      return false;
    try{
      for(int i=0; i<4; i++){
        int a=Integer.parseInt(st.nextToken());
          if((a>=0 && a<=255)){         
            omfg[i]=true;
          } else {
            omfg[i]=false;
          }
        if(omfg[i])
          aux++;
      }  
    } catch(NumberFormatException ex) {
      return false;
    }
    if(aux!=4)
      return false;
    return true;  
  }
    
  public void readmail(){
      //outputArea.setText(outputArea.getText()+"\n\n"+emails.toString()+"\n\n"+banner());
    if(gotemail){
      outputArea.setText(outputArea.getText()+"\n\n"+email+"\n\n"+banner());
    }else{
      outputArea.setText(outputArea.getText()+"\nYou have no mail...\n\n"+banner());
    }
  }
  
  public void clear(){
    outputArea.setText(""+banner());
  }
  
  public void setNotify(boolean a){
    notify=a;
  }
  
  public boolean getNotify(){
    return notify;
  }

  @Override
  public void show(){
      super.show();
      outputArea.setText(outputArea.getText());
  }

    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea inputArea;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea outputArea;
    // End of variables declaration//GEN-END:variables

    public static void main(String args[]){
        Console c = new Console();
        c.setVisible(true);
    }
}