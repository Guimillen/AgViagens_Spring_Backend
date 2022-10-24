package crud;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class ClienteController {
@Autowired
private ClienteRepository clienteRepository;
//Pegar todos os funcionarios
@GetMapping("/cliente")
public List<Cliente> getAllCliente() {
return clienteRepository.findAll();
}
//Pegar um funcionario usando seu ID
@GetMapping("/cliente/{id}")
public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new
ResourceNotFoundException("O cliente não existe com esse id : " + id));
return ResponseEntity.ok(cliente);
}
//Criar um novo funcionario
@PostMapping("/cliente")
public Cliente createCliente(@RequestBody Cliente cliente) {
return clienteRepository.save(cliente);
}
//Alterar um funcionario
@PutMapping("/cliente/{id}")
public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente
clienteDetails) {
Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new
ResourceNotFoundException("O Cliente não existe com esse id :" + id));
cliente.setPrimeiroNome(clienteDetails.getPrimeiroNome());
cliente.setUltimoNome(clienteDetails.getUltimoNome());
cliente.setEmailId(clienteDetails.getEmailId());
Cliente updatedCliente = clienteRepository.save(cliente);
return ResponseEntity.ok(updatedCliente);
}
//Deletar um funcionario
@DeleteMapping("/cliente/{id}")
public ResponseEntity<Map<String, Boolean>> deleteCliente (@PathVariable Long id) {
Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new
ResourceNotFoundException("O Cliente não existe com esse id :" + id));
clienteRepository.delete(cliente);
Map<String, Boolean> response = new HashMap<>();
response.put("deletado", Boolean.TRUE);
return ResponseEntity.ok(response);
}
}

