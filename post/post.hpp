#ifndef _POST_H
#define _POST_H
#include <string.h>
class Post
{
private:
    char _nome[32];
    char _conteudo[32];
    int _likes;
    int _dislikes;

public:
    Post(char *nome, char *conteudo);
    void like();
    void dislike();
    char *get_autor();
    char *get_conteudo();
    int n_likes();
    int n_dislikes();
    int sentimento();
};

Post::Post(char *nome, char *conteudo)
{
    this->_dislikes = 0;
    this->_likes = 0;
    strcpy(this->_conteudo, conteudo);
    strcpy(this->_nome, nome);
}

void Post::like()
{
    this->_likes++;
}

void Post::dislike()
{
    this->_dislikes++;
}

char *Post::get_autor()
{
    return this->_nome;
}
char *Post::get_conteudo()
{
    return this->_conteudo;
}

int Post::n_likes()
{
    return this->_likes;
}
int Post::n_dislikes()
{
    return this->_dislikes;
}
int Post::sentimento()
{
    if (this->_dislikes < this->_likes)
        return 1;
    return 0;
}
#endif