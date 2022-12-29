#language: pt

Funcionalidade: Alterar Senha
	como um usuário cadastrado na aplicação
	eu quero atualizar minha senha de acesso
	para que eu possa usar uma senha nova de autenticação
	
	Contexto: Autenticação de usuário
		Dado Acessar a página de autenticação do sistema
		E Informar o email "sergio.coti@gmail.com"
		E Informar a senha "@Admin123"
		Quando Solicitar a realização do acesso
		Então Sistema realiza a autenticação com sucesso
		
	Cenário: Alteração de senha com sucesso
		Dado Acessar a página de alteração de senha do usuário
		E Informar a senha atual "@Admin123"
		E Informar a nova senha "@Admin123"
		Quando Confirmar a atualização da senha
		Então Sistema informa que a senha foi atualizada com sucesso
		
	Cenário: Alteração de senha inválida
		Dado Acessar a página de alteração de senha do usuário
		E Informar a senha atual "@Teste123"
		E Informar a nova senha "@Admin123"
		Quando Confirmar a atualização da senha
		Então Sistema informa que a senha atual é inválida