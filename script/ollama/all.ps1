(
    'qwen2.5:1.5b',
    'qwen2.5-coder:1.5b',
    'hhao/qwen2.5-coder-tools:1.5b',
    'deepseek-r1:1.5b',
    'nomic-embed-text'
) | % {
    ollama pull $_
}

ls -File def | % {
    ollama create $_.Name.Replace("@", ":") -f $_.FullName
}

ollama list
