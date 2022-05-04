import matplotlib.pyplot as plt
import seaborn as sns

iris = sns.load_dataset('iris')

sns.set_style('darkgrid')

fig = plt.figure(figsize=(10, 15))
ax1 = fig.add_subplot(3, 1, 1)  # reglpot
sns.regplot(x='petal_length', y='petal_width', data=iris, ax=ax1)

ax2 = fig.add_subplot(3, 1, 2)  # scatter

setosa = iris[iris['species'] == 'setosa']
versicolor = iris[iris['species'] == 'versicolor']
virginica = iris[iris['species'] == 'virginica']
ax2.scatter(x=setosa['petal_length'],
            y=setosa['petal_width'], alpha=0.5, c="Green", label='setosa')
ax2.scatter(x=versicolor['petal_length'],
            y=versicolor['petal_width'], alpha=0.5, c="Purple", label='versicolor')
ax2.scatter(x=virginica['petal_length'],
            y=virginica['petal_width'], alpha=0.5, c="Blue", label='virginica')

ax2.set_xlabel('petal_length')
ax2.set_ylabel('petal_width')

species = ['setosa', 'versicolor', 'virginica']
ax2.legend(species, loc='upper left')

ax3 = fig.add_subplot(3, 1, 3)  # pie
ax3.pie(iris['species'].value_counts(),
        startangle=90, labels=species,
        autopct='%1.1f%%', colors=['Green', 'Purple', '#7777ff'])
plt.show()
