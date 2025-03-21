package br.com.serratec.service;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

//import br.com.serratec.configuration.MailConfig;
import br.com.serratec.dto.UsuarioRequestDTO;
import br.com.serratec.dto.UsuarioResponseDTO;
import br.com.serratec.entity.Perfil;
import br.com.serratec.entity.Usuario;
import br.com.serratec.entity.UsuarioPerfil;
import br.com.serratec.excepition.ConfirmarSenhaException;
import br.com.serratec.excepition.EmailException;
import br.com.serratec.repository.UsuarioRepository;
import jakarta.transaction.Transactional;

@Service //torna classe gerenciada pelo spring
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private PerfilService perfilService;
	
	//@Autowired
	//private MailConfig mailConfig;

	public List<UsuarioResponseDTO> listar() {
		
		List<Usuario> usuarios = repository.findAll();
		/*List<UsuarioResponseDTO> listaDTO = new ArrayList<>();
		
		for (Usuario usuario : usuarios) {
			listaDTO.add(new UsuarioResponseDTO(
					usuario.getId(),
					usuario.getNome(),
					usuario.getEmail()));
		}
		return listaDTO;*/
		
			//retorna a lista com progarmacao funcional com maplist com for imbutido automatizado
		return usuarios.stream().map((u) -> new UsuarioResponseDTO(u))
				.collect(Collectors.toList());
	}
	@Transactional
	public UsuarioResponseDTO inserir(UsuarioRequestDTO usuario) {
		if (!usuario.getSenha().equals(usuario.getConfirmaSenha())) {
			throw new ConfirmarSenhaException("Confirma de senha não confere!");
		}

		if (repository.findByEmail(usuario.getEmail()) != null) {
			throw new EmailException("Email Já Existe na Base");
		}
		Usuario u = new Usuario();
		u.setNome(usuario.getNome());
		u.setEmail(usuario.getEmail());
		u.setSenha(encoder.encode(usuario.getSenha()));

		Set<UsuarioPerfil> perfis = new HashSet<>();
		for (Perfil perfil : usuario.getPerfis()) {
			perfil = perfilService.buscar(perfil.getId());
			UsuarioPerfil up = new UsuarioPerfil(u, perfil, LocalDate.now());
			perfis.add(up);
		}
		
		u.setUsuarioPerfis(perfis);
		repository.save(u);
		//mailConfig.sendMail(u.getEmail(), "Cadastro de Usuario no Sistema", u.toString()); //envia email usuario
		return new UsuarioResponseDTO(u);

	}
	
}