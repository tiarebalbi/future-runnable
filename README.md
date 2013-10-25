future-runnable
===============

A ideia desse projeto era tornar mais fácil a execução de métodos em multthreads.

P.s: Este projeto é apenas uma simulação da ideia. Caso você tenha algo a contribuir utilize a sessão de Issues para enviar a sua sugestão.

# Próximos Passos:
	
1. Organizar o projeto considerando todos os cenários de teste;
2. Criar integração com frameworks de injeção CDI e Spring;
3. Criar eventos que permita você definir o momento dele ser executado;
4. Execução de métodos com recebimentos de parâmetros e anotificações assíncronas do momento de conclusão ou até mesmo de um determinado evento.

# Usando

Você deverá colocar a anotação @Runnable em cima do método que deve ser executado.

Exemplo: 


    @Runnable
	public void executar() {
		for(int i = 0; i< 100;i++) {
			System.out.println("Running: " + i);
		}
	}


E para inicializar o scanner que tem como objetivo localizar todos os métodos que utilizam esta anotação você deverá inicializar instanciando a classe Scanner.

Exemplo: 

    public static void main(String[] args)  {
		    new Scanner();
    }   
	
	
