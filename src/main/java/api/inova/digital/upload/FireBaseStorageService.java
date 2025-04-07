package api.inova.digital.upload;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Acl;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.StorageClient;
import com.google.firebase.internal.FirebaseService;

@Service
public class FireBaseStorageService {

	@PostConstruct
	private void init() throws IOException {
		
		if (FirebaseApp.getApps().isEmpty()) {
			
			// Ler o arquivo de configuração da conta
			InputStream serviceAccount = 
					FirebaseService
					.class
					.getResourceAsStream("/odonto-e840d-firebase-adminsdk-fbsvc-f9676a995f.json");
			
			// Definir os dados necessários para acessar o Storage
			FirebaseOptions options = new FirebaseOptions.Builder()
					  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
					  .setStorageBucket("teste-ds3.appspot.com")
					  .build();

			// Inicializar o serviço cliente Firebase
			FirebaseApp.initializeApp(options);
			
		}
		
	}
	
	public String upload(FileUpload file) {
		
		// Criar um acesso ao bucket
		Bucket bucket = StorageClient.getInstance().bucket();
		
		// Transformar o base64 em bytes novamente (arquivo)
		byte[] arquivo = Base64.getDecoder().decode(file.getBase64());
		
		// Criar o arquivo com os dados fornecido
		Blob blob = bucket.create(
				file.getFileName(), 
				arquivo, 
				file.getMimeType());
		
	
		// Configurar uma regra para que o arquivo possa ser lido
		blob.createAcl(Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER));
		
		System.out.println("https://storage.googleapis.com/" + bucket.getName() + "/"+ file.getFileName());
		
		return "https://storage.googleapis.com/" + bucket.getName() + "/"+ file.getFileName();
	}
	
}









