#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdarg.h>
#include <limits.h>
#include <float.h>
#include <ctype.h>
#include <math.h>
#include <time.h>

typedef char byte;
typedef void *Any;
typedef enum bool
{
    false,
    true
} bool;

#define null NULL
#define PI 3.141592653589793
#define E 2.718281828459045

#define as(value, type) ((type)(value))
#define default(type) as(0, type)

#define ref(value, type) as(&value, type *)
#define set(pointer, type) (*as(pointer, type *))
#define get(pointer, type) (*as(pointer, type *))

#define new(size, type) calloc(size, sizeof(type))
#define del(pointer, type) free(as(pointer, type))

#define assert(expression) (expression ? (void)0 : (printf("[ERROR]%s(%d): assert fail %s\n", __FILE__, __LINE__, #expression), exit(-1)))

#define try(body) body;

#define catch(body) body;

#define finally(body) body;

#define throw goto

#define swap(type, arr, i, j) \
    {                         \
        type tmp = arr[i];    \
        arr[i] = arr[j];      \
        arr[j] = tmp;         \
    }

#define hello_world printf("Hello World!\n")
#define newline() putchar('\n')

#define args_envp                       \
    {                                   \
        char **s;                       \
        for (s = argv; *s != null; s++) \
            puts(*s);                   \
        for (s = envp; *s != null; s++) \
            puts(*s);                   \
    }

#define utf8() system("chcp 65001")
#define pause() system("pause")

#define foreach(i, from, to, step, body)  \
    {                                     \
        int i;                            \
        for (i = from; i < to; i += step) \
            body;                         \
    }

#define start(body)                                \
    int main(int argc, char *argv[], char *envp[]) \
    {                                              \
        body;                                      \
        return 0;                                  \
    }

#define class(name, fields, methods) \
    typedef struct name              \
    {                                \
        fields;                      \
    } *name;                         \
    methods

#pragma warning(disable : 4019)

class(
    String,
    int const length;
    char const *const value,

    String new_string(char *chars)
    {
        String self = new (1, struct String);
        int n = strlen(chars);
        set(&self->length, int) = n;
        set(&self->value, char *) = new (n, char);
        strcpy(as(self->value, char *), chars);
        return self;
    }

    void del_string(String self)
    {
        del(self->value, char *);
        set(&self->value, char *) = default(char *);
        set(&self->length, int) = default(int);
        del(self, String);
    }

);

class(
    Array,
    int const length;
    Any *const element,

    Array new_array(int length)
    {
        Array self = new (1, struct Array);
        set(&self->length, int) = length;
        set(&self->element, Any *) = new (length, Any *);
        return self;
    }

    void del_array(Array self)
    {
        del(self->element, Any *);
        set(&self->element, Any *) = default(Any *);
        set(&self->length, int) = default(int);
        del(self, Array);
    }

);

class(
    Node,
    Any value;
    struct Node * next,

    Node new_Node(Any value)
    {
        Node self = new (1, struct Node);
        self->value = value;
        return self;
    }

    void del_Node(Node self)
    {
        self->value = default(Any);
        self->next = default(Node);
        del(self, Node);
    }

);

#pragma warning(default : 4019)

int gcd(int x, int y)
{
    while (y != 0)
    {
        int r = x % y;
        x = y;
        y = r;
    }
    return x;
}

int lcm(int x, int y)
{
    return x * y / gcd(x, y);
}
