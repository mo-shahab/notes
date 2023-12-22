def is_balanced_parentheses(s):
    stack = []
    mapping = {')': '(', '}': '{', ']': '['}

    for char in s:
        if char in mapping.values():
            stack.append(char)
        elif char in mapping.keys():
            if not stack or stack.pop() != mapping[char]:
                return False
        else:
            # Ignore non-parentheses characters
            pass
    return not stack  # The string is balanced if the stack is e
# Example usage:
example_str = "{[()]}"
if is_balanced_parentheses(example_str):
    print("The parentheses are balanced.")
else:
    print("The parentheses are not balanced.")
