#language: pt

Funcionalidade: Recuperar Senha
	como um usuário cadastrado na aplicação
	eu quero recuperar minha senha de acesso
	para que eu possa acessar o sistema
	
Cenário: Recuperação de senha com sucesso
	Dado Acessar a página de recuperação de senha
	E Informar o email atual "sergio.coti@bol.com.br"
	Quando Confirmar a recuperação da senha
	Então Sistema realiza a recuperação da senha com sucesso
	
Cenário: Recuperação de senha com email inválido
	Dado Acessar a página de recuperação de senha
	E Informar o email atual "teste@gmail.com.br"
	Quando Confirmar a recuperação da senha
	Então Sistema informa que o email é inválido