#language: pt

Funcionalidade: Acessar Conta
	como um usuário cadastrado na aplicação
	eu quero acessar minha conta de usuário
	para que eu possa gerenciar meus dados
	
	Cenário: Acessar conta com sucesso
		Dado Acessar a página de autenticação do sistema
		E Informar o email "sergio.coti@gmail.com"
		E Informar a senha "@Admin123"
		Quando Solicitar a realização do acesso
		Então Sistema realiza a autenticação com sucesso
		
	Cenário: Acesso negado
		Dado Acessar a página de autenticação do sistema
		E Informar o email "testador@gmail.com"
		E Informar a senha "@Testador123"
		Quando Solicitar a realização do acesso
		Então Sistema informa que o acesso é negado