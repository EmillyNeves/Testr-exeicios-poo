#ifndef _CLT_HPP_
#define _CLT_HPP_
#include <string>
#include "FuncionarioContratado.hpp"
class CLT : public FuncionarioContratado
{
private:
    double _ticket_alimentacao;
    double _desconto_fgts;
    double _desconto_irrf;

protected:
    double bonus() override;
    double descontos() override;

public:
    CLT(std::string nome, double salario_base, 
        double ticket, double fgts, double irrf);
    ~CLT();
};
#endif // _CLT_HPP_
