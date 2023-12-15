#ifndef SEMANTICS_STRUCTURES
#define SEMANTICS_STRUCTURES

typedef enum _NodeType {
  NONE = 0,
  N_PRG,
  N_STMTS,
  N_STMT,
  N_EXPR,
} NodeType;

typedef struct _Node{
  NodeType prodRule;
  int      token;
  char*    id; // This is required for all token in order to throw errors
  int      numChild;
  struct _Node**   children;
} TreeNode;

TreeNode* makeNode(NodeType t, int numChild, ...);
TreeNode* generateTerminal(int token, char * const id);
#endif
