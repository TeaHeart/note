# 排序算法

---

## 交换函数

```c
void swap(int *array, int i, int j)
{
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
}
```

## 冒泡排序

```c
void bubble_sort(int *array, int from, int to)
{
    int i;
    int j;
    for (i = from; i < to; i++)
    {
        for (j = from; j < to - i + from - 1; j++)
        {
            if (array[j + 1] < array[j])
            {
                swap(array, j + 1, j);
            }
        }
    }
}
```

## 选择排序

```c
void select_sort(int *array, int from, int to)
{
    int i;
    int j;
    int k;
    for (i = from; i < to; i++)
    {
        for (k = j = i; j < to; j++)
        {
            if (array[j] < array[k])
            {
                k = j;
            }
        }
        swap(array, k, i);
    }
}
```

## 插入排序

```c
void insert_sort(int *array, int from, int to)
{
    int i;
    int j;
    int temp;
    for (i = from + 1; i < to; i++)
    {
        temp = array[i];
        for (j = i; j - 1 >= from; j--)
        {
            if (array[j - 1] < temp)
            {
                break;
            }
            array[j] = array[j - 1];
        }
        array[j] = temp;
    }
}
```

## 希尔排序

```c
void shell_sort(int *array, int from, int to)
{
    int i;
    int j;
    int step;
    int temp;
    for (step = (to - from) / 2; step > 0; step /= 2)
    {
        for (i = step; i < to; i++)
        {
            temp = array[i];
            for (j = i; j - step >= from; j -= step)
            {
                if (array[j - step] < temp)
                {
                    break;
                }
                array[j] = array[j - step];
            }
            array[j] = temp;
        }
    }
}
```

## 归并排序

```c
void merge_sort(int *array, int from, int to, int *temp)
{
    int i;
    int j;
    int k;
    int middle;
    if (to - from <= 1)
    {
        return;
    }
    i = k = from;
    j = middle = (unsigned int)(from + to) / 2;
    merge_sort(array, from, middle, temp);
    merge_sort(array, middle, to, temp);
    while (i < middle && j < to)
    {
        if (array[i] < array[j])
        {
            temp[k++] = array[i++];
        }
        else
        {
            temp[k++] = array[j++];
        }
    }
    while (i < middle)
    {
        temp[k++] = array[i++];
    }
    while (j < to)
    {
        temp[k++] = array[j++];
    }
    while (from < to)
    {
        array[from] = temp[from++];
    }
}
```

## 快速排序

```c
void quick_sort(int *array, int from, int to)
{
    int i;
    int lt;
    int gt;
    int middle;
    if (to - from <= 1)
    {
        return;
    }
    i = lt = from;
    gt = to;
    middle = array[i];
    while (i < gt)
    {
        if (array[i] < middle)
        {
            swap(array, lt++, i++);
        }
        else if (array[i] > middle)
        {
            swap(array, i, --gt);
        }
        else
        {
            i++;
        }
    }
    quick_sort(array, from, lt);
    quick_sort(array, gt, to);
}
```

## 堆排序

```c
void sink(int *array, int k, int n, int offset)
{
    int i;
    int temp = array[k + offset];
    for (i = 2 * k + 1; i < n; k = i, i = 2 * k + 1)
    {
        if (i + 1 < n && array[i + offset] < array[i + 1 + offset])
        {
            i++;
        }
        if (array[i + offset] < temp)
        {
            break;
        }
        array[k + offset] = array[i + offset];
    }
    array[k + offset] = temp;
}

void heap_sort(int *array, int from, int to)
{
    int i;
    int n = to - from;
    for (i = n / 2; i >= 0; i--)
    {
        sink(array, i, n, from);
    }
    for (i = n - 1; i > 0; i--)
    {
        swap(array, from, i + from);
        sink(array, 0, i, from);
    }
}
```

## 计数排序

```c
void counting_sort(int *array, int from, int to)
{
    int i;
    int n;
    int *count;
    int min = array[from];
    int max = array[from];
    for (i = from; i < to; i++)
    {
        if (array[i] < min)
        {
            min = array[i];
        }
        else if (array[i] > max)
        {
            max = array[i];
        }
    }
    n = max - min + 1;
    count = (int *)calloc(n, sizeof(int));
    for (i = from; i < to; i++)
    {
        count[array[i] - min]++;
    }
    for (i = 0; i < n; i++)
    {
        while (count[i]-- != 0)
        {
            array[from++] = min + i;
        }
    }
    free(count);
}
```

## 桶排序

```c
void bucket_sort(int *array, int from, int to, int expect_bucket_size, void (*other_sort)(int *, int, int))
{
    int i;
    int j;
    int n;
    int **buckets;
    int *bucket_size;
    int min = array[from];
    int max = array[from];
    for (i = from; i < to; i++)
    {
        if (array[i] < min)
        {
            min = array[i];
        }
        else if (array[i] > max)
        {
            max = array[i];
        }
    }
    n = (max - min + 1) / expect_bucket_size + 1;
    buckets = (int **)calloc(n, sizeof(int *));
    bucket_size = (int *)calloc(n, sizeof(int));
    for (i = from; i < to; i++)
    {
        j = (array[i] - min) / expect_bucket_size;
        buckets[j] = (int *)realloc(buckets[j], (bucket_size[j] + 1) * sizeof(int));
        buckets[j][bucket_size[j]++] = array[i];
    }
    for (i = 0; i < n; i++)
    {
        other_sort(buckets[i], 0, bucket_size[i]);
        for (j = 0; j < bucket_size[i]; j++)
        {
            array[from++] = buckets[i][j];
        }
    }
    for (i = 0; i < n; i++)
    {
        free(buckets[i]);
    }
    free(buckets);
    free(bucket_size);
}
```

## 基数排序

```c
void radix_sort(int *array, int from, int to)
{
    int i;
    int j;
    int k;
    int radix;
    int *buckets[20] = {NULL};
    int bucket_size[20] = {0};
    int max = array[from];
    for (i = from; i < to; i++)
    {
        if (abs(array[i]) > abs(max))
        {
            max = array[i];
        }
    }
    for (radix = 1; max != 0; max /= 10, radix *= 10)
    {
        for (i = from; i < to; i++)
        {
            j = (array[i] / radix) % 10 + 10;
            buckets[j] = (int *)realloc(buckets[j], (bucket_size[j] + 1) * sizeof(int));
            buckets[j][bucket_size[j]++] = array[i];
        }
        k = from;
        for (i = 0; i < 20; i++)
        {
            for (j = 0; j < bucket_size[i]; j++)
            {
                array[k++] = buckets[i][j];
            }
            bucket_size[i] = 0;
        }
    }
    for (i = 0; i < 20; i++)
    {
        free(buckets[i]);
    }
}
```
