package vector;
import java.io.IOException;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 * View-Controller for the person table.
 * 
 * @author Nick Caamano
 */
public class EventController 
{
	
        VectorFunctions CalcObject = new VectorFunctions();
        
	@FXML
	private Button AddButton;
	@FXML
	private Button CrossButton;
        @FXML 
        private Button DotButton;
        @FXML
        private Button ResetAll;
        @FXML 
        private Button AddReset;
        @FXML 
        private Button CrossProductReset;
        @FXML 
        private Button DotProductReset;
        @FXML 
        private Button VectorAReset;
        @FXML 
        private Button VectorBReset;
        @FXML
        private Button ResetBoth;
        @FXML
        private Label AddResultLabel;   
        @FXML
        private Label CrossResultLabel;    
        @FXML
        private Label DotResultLabel;  
        @FXML
        private Label MagnitudeA;
        @FXML
        private Label MagnitudeB;
        @FXML
        private Label NormalizationA;
        @FXML
        private Label NormalizationB;
        @FXML 
        private Label RadianLabel;
        @FXML
        private Label DegreeLabel;
        @FXML
        private Label AddDescription;
        @FXML
        private Label CrossDescription;
        @FXML
        private Label DotDescription;
        @FXML 
        private Label BontoA;
        @FXML 
        private Label AontoB;
        @FXML
        private TextField VectorA_I;
        @FXML
        private TextField VectorA_J;
        @FXML
        private TextField VectorA_K;
        @FXML
        private TextField VectorB_I;
        @FXML
        private TextField VectorB_J;
        @FXML
        private TextField VectorB_K;
        @FXML
        private MenuItem Close;
        @FXML
        private MenuItem MenuReset;
        @FXML
        private MenuItem About;
        
        
       
        
	/**
	 * The constructor (is called before the initialize()-method).
	 */
	public EventController() 
        {
           
	}
	
	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() 
        {
		// Handle Button event.
		AddButton.setOnAction((event) -> 
                {
                    double[] VectorA = getVectorA();
                    double[] VectorB = getVectorB();
                    double[] SumResult = CalcObject.addVectors(VectorA, VectorB);
                    
                    String resultI = Double.toString( SumResult[0]);
                    String resultJ = Double.toString(SumResult[1]);
                    String resultK = Double.toString(SumResult[2]);
                    String result = "<" + resultI + ", " + resultJ + ", " + resultK + ">";
                    AddResultLabel.setText(result);   
                    
                    String description = "= <" + VectorA[0] + ", " +
                                                 VectorA[1] + ", " +
                                                 VectorA[2] + "> + <" +
                                                 VectorB[0] + ", " +
                                                 VectorB[1] + ", " + 
                                                 VectorB[2] + ">";
                    AddDescription.setText(description);
		});
                
                CrossButton.setOnAction((event) -> 
                {
                    double[] VectorA = getVectorA();
                    double[] VectorB = getVectorB();
                    double[] CrossResult = CalcObject.crossProduct(VectorA, VectorB);
                    
                    String resultI = Double.toString( CrossResult[0]);
                    String resultJ = Double.toString(CrossResult[1]);
                    String resultK = Double.toString(CrossResult[2]);
                    String result = "<" + resultI + ", " + resultJ + ", " + resultK + ">";
                    CrossResultLabel.setText(result);
                    
                    String description = "= <" + VectorA[0] + ", " +
                                                 VectorA[1] + ", " +
                                                 VectorA[2] + "> X <" +
                                                 VectorB[0] + ", " +
                                                 VectorB[1] + ", " + 
                                                 VectorB[2] + ">";
                    CrossDescription.setText(description);
                });
                
                DotButton.setOnAction((event) -> 
                {
                    double[] VectorA = getVectorA();
                    double[] VectorB = getVectorB();
                    double DotResult = CalcObject.dotProduct(VectorA, VectorB);
                    
                    
                    String result = Double.toString(DotResult);
                    DotResultLabel.setText(result);
                    
                    String description = "= <" + VectorA[0] + ", " +
                                                 VectorA[1] + ", " +
                                                 VectorA[2] + "> * <" +
                                                 VectorB[0] + ", " +
                                                 VectorB[1] + ", " + 
                                                 VectorB[2] + ">";
                    DotDescription.setText(description);
                });
                
                AddReset.setOnAction((event) ->
                {
                    AddResultLabel.setText("<>"); 
                    AddDescription.setText("");
                });
                
                CrossProductReset.setOnAction((event) ->
                {
                    CrossResultLabel.setText("<>");
                    CrossDescription.setText("");
                    
                });
                 
                DotProductReset.setOnAction((event) ->
                {
                    DotResultLabel.setText("0.0");
                    DotDescription.setText("");
                    
                });
                
                ResetAll.setOnAction((event) ->
                {
                    AddResultLabel.setText("<>");
                    CrossResultLabel.setText("<>");
                    DotResultLabel.setText("0.0"); 
                    VectorA_I.setText("0.0");
                    VectorA_J.setText("0.0");
                    VectorA_K.setText("0.0");
                    MagnitudeA.setText("0.0");
                    NormalizationA.setText("           <>");
                    VectorB_I.setText("0.0");
                    VectorB_J.setText("0.0");
                    VectorB_K.setText("0.0");
                    MagnitudeB.setText("0.0");
                    NormalizationB.setText("           <>");
                    AddDescription.setText("");
                    CrossDescription.setText("");
                    DotDescription.setText("");
                });
                
                VectorAReset.setOnAction((event)->
                {
                    VectorA_I.setText("0.0");
                    VectorA_J.setText("0.0");
                    VectorA_K.setText("0.0");
                    MagnitudeA.setText("0.0");
                    NormalizationA.setText("           <>");
                   
                });
                
                VectorBReset.setOnAction((event)->
                {
                    VectorB_I.setText("0.0");
                    VectorB_J.setText("0.0");
                    VectorB_K.setText("0.0");
                    MagnitudeB.setText("0.0");
                    NormalizationB.setText("           <>");
                });
      
                ResetBoth.setOnAction((event) -> 
                {
                    VectorA_I.setText("0.0");
                    VectorA_J.setText("0.0");
                    VectorA_K.setText("0.0");
                    MagnitudeA.setText("0.0");
                    NormalizationA.setText("           <>");
                    VectorB_I.setText("0.0");
                    VectorB_J.setText("0.0");
                    VectorB_K.setText("0.0");
                    MagnitudeB.setText("0.0");
                    NormalizationB.setText("           <>");
                    
                });
               
		VectorA_I.textProperty().addListener((observable, oldValue, newValue) ->
                {
                   ResetVectorAProperties();
                   ResetAngles();
                   ResetProjections();
                });
                VectorA_J.textProperty().addListener((observable, oldValue, newValue) ->
                {
                    ResetVectorAProperties();
                    ResetAngles();
                    ResetProjections();
                });
                VectorA_K.textProperty().addListener((observable, oldValue, newValue) ->
                {
                   ResetVectorAProperties();
                   ResetAngles();
                   ResetProjections();
                });
                
                VectorB_I.textProperty().addListener((observable, oldValue, newValue) ->
                {
                    ResetVectorBProperties();
                    ResetAngles();
                    ResetProjections();
                });
                VectorB_J.textProperty().addListener((observable, oldValue, newValue) ->
                {
                    ResetVectorBProperties();
                    ResetAngles();
                    ResetProjections();
                });
                VectorB_K.textProperty().addListener((observable, oldValue, newValue) ->
                {
                     ResetVectorBProperties();
                     ResetAngles();
                     ResetProjections();
                });
                
                Close.setOnAction((event) ->
                {
                    Platform.exit();
                });
                
                About.setOnAction((event) ->
                {
                    Pane root;
                    try 
                    {
                      root = FXMLLoader.load(getClass().getResource("About.fxml"));
                      Stage stage = new Stage();
                      stage.setTitle("About");
                      
                      root.setBackground(new Background(new BackgroundFill(Color.web("#FFFFFF"), CornerRadii.EMPTY, Insets.EMPTY)));
                      stage.setScene(new Scene(root, 600, 495));
                      stage.show();
                            // Hide this current window (if this is what you want)
                     // ((Node)(event.getSource())).getScene().getWindow().hide();
                    }
                    catch (IOException e) 
                    {
                            e.printStackTrace();
                    }
                });
                
                MenuReset.setOnAction((event) ->
                {
                    AddResultLabel.setText("<>");
                    CrossResultLabel.setText("<>");
                    DotResultLabel.setText("0.0"); 
                    VectorA_I.setText("0.0");
                    VectorA_J.setText("0.0");
                    VectorA_K.setText("0.0");
                    MagnitudeA.setText("0.0");
                    NormalizationA.setText("           <>");
                    VectorB_I.setText("0.0");
                    VectorB_J.setText("0.0");
                    VectorB_K.setText("0.0");
                    MagnitudeB.setText("0.0");
                    NormalizationB.setText("           <>");
                });
                
                
               
		
	} // init
        
        private double[] getVectorA()
        {
            double[] vectorA = 
                        {
                            Double.parseDouble(VectorA_I.getText()),
                            Double.parseDouble(VectorA_J.getText()),
                            Double.parseDouble(VectorA_K.getText())
                        };
            
            return vectorA;
        }
        
        private double[] getVectorB()
        {
             double[] vectorB = 
                        {
                            
                            Double.parseDouble(VectorB_I.getText()),
                            Double.parseDouble(VectorB_J.getText()),
                            Double.parseDouble(VectorB_K.getText())
                        };
             
             return vectorB;
        }
	
        private void ResetVectorAProperties()
        {
            double[] VectorA = getVectorA();
                    double magnitude = CalcObject.VectorMagnitude(VectorA);
                    MagnitudeA.setText(Double.toString(magnitude));
                    
                    //normalization set
                    double[] N_VectorA = getVectorA();
                    double[] normalization = CalcObject.VectorNormalization(N_VectorA);
                    NormalizationA.setText("<" + normalization[0] + ", " +
                                                 normalization[1] + ", " +
                                                 normalization[2] + ">"); 
        }
        
        private void ResetVectorBProperties()
        {
            double[] VectorB = getVectorB();
                    double magnitude = CalcObject.VectorMagnitude(VectorB);
                    MagnitudeB.setText(Double.toString(magnitude));
                    
                    //normalization set
                    double[] N_VectorB = getVectorB();
                    double[] normalization = CalcObject.VectorNormalization(N_VectorB);
                    NormalizationB.setText("<" + normalization[0] + ", " +
                                                 normalization[1] + ", " +
                                                 normalization[2] + ">");   
        }
        
        private void ResetAngles()
        {
            double[] A_VectorA = getVectorA();
                    double[] A_VectorB = getVectorB();
                    
                    double radians = CalcObject.VectorAngle(A_VectorA, A_VectorB);
                    double degrees = CalcObject.RadiansToDegrees(radians);
                    String strRadians = Double.toString(radians);
                    String strDegrees = Double.toString(degrees);
                    RadianLabel.setText(strRadians + " Radians");
                    DegreeLabel.setText(strDegrees + " Degrees");
        }
        
        private void ResetProjections()
        {
            double[] VectorA = getVectorA();
            double[] VectorB = getVectorB();
            
            double[] projectionBtoA = CalcObject.Projection(VectorA, VectorB);
            double[] projectionAtoB = CalcObject.Projection(VectorB, VectorA);
            
            String BtoA = "<" + projectionBtoA[0] + ", " +
                              + projectionBtoA[1] + ", " +
                              + projectionBtoA[2] + ">";
             String AtoB = "<" + projectionAtoB[0] + ", " +
                              + projectionAtoB[1] + ", " +
                              + projectionAtoB[2] + ">";
            BontoA.setText(BtoA);
            AontoB.setText(AtoB);
        }
}       
